/**
 * 
 */
package com.webank.Appointment.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.webank.Appointment.module.ActivityInfo;
import com.webank.Appointment.module.PersonInfo;
import com.webank.Appointment.service.ActSvc;
import com.webank.Appointment.service.UserService;
import com.webank.Appointment.utils.HttpUtil;
import com.webank.Appointment.utils.SessionUtil;
import com.webank.Appointment.utils.StringUtil;
import com.webank.Appointment.utils.WXThirdSessionUtil;


/**
 * @author 
 * @date 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	/*@Autowired
	private ActSvc actsvc;*/
	
	/**
	 * 登陆
	 * @return void
	 */
	@ResponseBody
	@RequestMapping(value = "login")
	public HashMap<String, String> login(HttpServletRequest request, String code) {
		HashMap<String, String> map = new HashMap<String, String>();
		if (code == null || StringUtil.isEmptyOrBlank(code)){
			map.put("errMsg", "INVALID_CODE");
			return map;
		}
		String appid = "wx44fddc797b29ee4c";
		String secret = "38c7369bea942c3a4789e41dcacd9dbf";
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("https://api.weixin.qq.com/sns/jscode2session?appid=");
		sBuffer.append(appid);
		sBuffer.append("&secret=");
		sBuffer.append(secret);
		sBuffer.append("&js_code=");
		sBuffer.append(code);
		sBuffer.append("&grant_type=authorization_code");
		String url = sBuffer.toString();
		String contentString = HttpUtil.httpRequest(url, "GET", null);
		
		logger.info("login request [code="+code+"]");
		
		Gson gson = new Gson();
		HashMap<String, String> result = gson.fromJson(contentString, HashMap.class);
		HashMap<String, String> return_data = new HashMap<String, String>();
		String openid = result.get("openid");
		String session_key = result.get("session_key");
		if (openid == null){
			return_data.put("errMsg", result.get("errmsg"));
			logger.error("Exchange session fail. Response:" + contentString);
		}
		else {
			String third_sessionString = WXThirdSessionUtil.generate(session_key);
			
			StringBuffer thirdSessValueBuffer = new StringBuffer();
			thirdSessValueBuffer.append(session_key);
			thirdSessValueBuffer.append("+");
			thirdSessValueBuffer.append(openid);
			SessionUtil.setAttribute(request.getSession(), third_sessionString, thirdSessValueBuffer.toString());
			
			//System.out.println("session_key:   "+session_key);
			//System.out.println("openid:    "+openid);
			logger.info("[session_key=" + session_key + "]");
			logger.info("[openid=" + openid + "]");
			
			
			//todo: 用户信息入库，以openid为标志
			//如果用户已经存在，则不需要再次存储
			if (!userService.isExist(openid)){
				PersonInfo personInfo = new PersonInfo();
				personInfo.setOpenId(openid);
				userService.addUser(personInfo);
			}

			return_data.put("thirdSession", third_sessionString);
		}	
		return return_data;
	}
	
	/*@ResponseBody
	@RequestMapping(value = "launch")
	public HashMap<String, Object> launchAct(HttpServletRequest request, ActivityInfo activityInfo){
		HashMap<String, Object> return_data = new HashMap<String, Object>();
		activityInfo.setActivityState(0);
		Date nowDate = new Date();
		activityInfo.setLaunchTime((new SimpleDateFormat("yyyy-MM-dd")).format(nowDate));
		activityInfo.setNumberNow(0);
		if (actsvc.addActivity(activityInfo)){
			return_data.put("errMsg", "ok");
		}
		else {
			return_data.put("errMsg", "launch fail");
		}
		return_data.put("data", new ArrayList<String>());
		return return_data;
	}*/
}
