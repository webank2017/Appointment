/**
 *  @Title: Test.java 
 *  @Package com.cn21.FrequencyControl 
 *  @Description: TODO(用一句话描述该文件做什么) 
 *  @author chenxiaofeng
 *  @date 2016年8月8日 下午5:21:52 
 *  @version V1.0 
 */
package com.webank.Appointment.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.webank.Appointment.controller.common.Page;
import com.webank.Appointment.module.ActivityInfo;
import com.webank.Appointment.module.PaticipateInfo;
import com.webank.Appointment.module.PersonInfo;
import com.webank.Appointment.service.ActivityService;
import com.webank.Appointment.utils.UserIdDecoder;


/**
 * @author 
 * @date 
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
	private static Logger logger = Logger.getLogger(ActivityController.class);
	
	@Autowired
	protected ActivityService activiyService;
	@Autowired
	private UserIdDecoder userIdDecoder;
	
	/**
	 * 活动列表
	 * @param userId
	 * @param request
	 * @param respons
	 * @return
	 */
	@RequestMapping(value = "/home/{userId}")
	@ResponseBody
	public String activityList(@PathVariable String userId,HttpServletRequest request, HttpServletResponse respons) {
		logger.info("3rd session: " + userId);
		int userid = userIdDecoder.getUserId(userId);
		logger.info("userid = " + String.valueOf(userid));
		Page<ActivityInfo> activityList=activiyService.getActivityList(Page.DEFAULT_PAGE_NO,Page.DEFAULT_PAGE_SIZE,userid);
		JSONObject result = (JSONObject) JSONObject.toJSON(activityList);
		return result.toJSONString();
	}
	
	/**
	 * 活动详情
	 * @param userId
	 * @param activityId
	 * @param request
	 * @param respons
	 * @return
	 */
	@RequestMapping(value = "/detail/{activityId}")
	@ResponseBody
	public String activityDetail(@PathVariable int activityId,HttpServletRequest request, HttpServletResponse respons) {
		ActivityInfo activity=activiyService.getActivity(activityId);
		List<PersonInfo> joiner=activiyService.getJoiner(activityId);
		JSONObject result = new JSONObject();
		result.put("data", (JSONObject) JSONObject.toJSON(activity));
		result.put("joiner", joiner);
		return result.toJSONString();
	}
	
	/**
	 * 我发起的活动
	 * @param userId
	 * @param activityId
	 * @param request
	 * @param respons
	 * @return
	 */
	@RequestMapping(value = "/myLead/{userId}")
	@ResponseBody
	public String MyActivity(@PathVariable String userId,HttpServletRequest request, HttpServletResponse respons) {
		logger.info("3rd session: " + userId);
		int userid = userIdDecoder.getUserId(userId);
		logger.info("userid = " + String.valueOf(userid));
		
		List<ActivityInfo> activity=activiyService.getActivityByUId(userid);
		JSONArray result = new JSONArray();
		result.addAll(activity);
		return result.toJSONString();
	}
	
	/**
	 * 我参加的活动
	 * @param userId
	 * @param activityId
	 * @param request
	 * @param respons
	 * @return
	 */
	@RequestMapping(value = "/myJoin/{userId}")
	@ResponseBody
	public String MyPaticipate(@PathVariable String userId,HttpServletRequest request, HttpServletResponse respons) {
		logger.info("3rd session: " + userId);
		int userid = userIdDecoder.getUserId(userId);
		logger.info("userid = " + String.valueOf(userid));
		
		List<ActivityInfo> activity=activiyService.getMyPaticipate(userid);
		JSONArray result = new JSONArray();
		result.addAll(activity);
		return result.toJSONString();
	}
	/**
	 * 加入活动
	 * @param userId
	 * @param activityId
	 * @param request
	 * @param respons
	 * @return
	 */
	@RequestMapping(value = "/join")
	@ResponseBody
	public Map<String,Object> joinActivity(HttpServletRequest request, HttpServletResponse respons) {
		HashMap<String, Object> return_data = new HashMap<String, Object>();
		
		logger.info("3rd session: " + request.getParameter("userId"));
		int userid = userIdDecoder.getUserId(request.getParameter("userId"));
		logger.info("userid = " + String.valueOf(userid));
		
		PaticipateInfo paticipateInfo = new PaticipateInfo();
		paticipateInfo.setActivityId(Integer.parseInt(request.getParameter("activityId")));
		paticipateInfo.setUsername(request.getParameter("username"));
		paticipateInfo.setUserId(userid);
		paticipateInfo.setPhone(request.getParameter("phone"));
		paticipateInfo.setGender(Integer.parseInt(request.getParameter("gender")));
		paticipateInfo.setNumber(1);//request.getParameter("number");
		paticipateInfo.setPaticipateTime(new Timestamp(System.currentTimeMillis()));
		if(activiyService.join(paticipateInfo)){
			return_data.put("errMsg", "ok!");
		}
		else return_data.put("errMsg", "join failed!");
		return_data.put("data", new ArrayList<String>());
		return return_data;
	}
	

	/**
	 * 发起活动
	 * @param request
	 * @param activityInfo
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "launch/{thirdSession}")
	public HashMap<String, Object> launchAct(@PathVariable String thirdSession,HttpServletRequest request) throws UnsupportedEncodingException{

		
		ActivityInfo info = new ActivityInfo();
		info.setActivityTheme(URLDecoder.decode(request.getParameter("activityTheme"),"utf-8") );
		info.setContacter(URLDecoder.decode(request.getParameter("contacter"),"utf-8"));
		info.setStartTime(request.getParameter("startTime"));
		info.setEndTime(request.getParameter("endTime"));
		info.setActivityType(Integer.parseInt(request.getParameter("activityType")));
		info.setActivityPlace(URLDecoder.decode(request.getParameter("activityPlace"),"utf-8"));
		info.setActivityPlace_x(Double.parseDouble(request.getParameter("activityPlace_x")));
		info.setActivityPlace_y(Double.parseDouble(request.getParameter("activityPlace_y")));
		info.setNumberUp(Integer.parseInt(request.getParameter("numberUp")));
		info.setActivityInfo(URLDecoder.decode(request.getParameter("activityInfo"),"utf-8"));
		info.setIfRequire(Integer.parseInt(request.getParameter("ifRequire")));
		info.setContacterNumber(request.getParameter("contacterNumber"));
		info.setGenderRequire(Integer.parseInt(request.getParameter("genderRequire")));
		
		HashMap<String, Object> return_data = new HashMap<String, Object>();
		info.setActivityState(0);
		Date nowDate = new Date();
		info.setLaunchTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(nowDate));
		info.setNumberNow(0);
		/*Enumeration<String> attributeNames = request.getSession().getAttributeNames();
		while(attributeNames.hasMoreElements()) {
			String nextElement = attributeNames.nextElement();
			logger.info("attributeName:"+nextElement);
			logger.info("attributevalue:"+request.getSession().getAttribute(nextElement));
		}*/
		int userid = userIdDecoder.getUserId(thirdSession);
		
		logger.info("ThirdSession to UserId: [thirdSession=" + thirdSession + "][userid="+String.valueOf(userid));
		
		if (userid >= 0){
			info.setUserId(userid);
			if (activiyService.addActivity(info)){
				return_data.put("errMsg", "ok");
			}
			else {
				return_data.put("errMsg", "launch fail");
			}
		}
		else {
			return_data.put("errMsg", "SESSION_ERROR");
		}
		return_data.put("data", new ArrayList<String>());
		return return_data;
	}
	/**
	 * 退出活动
	 * @param request
	 * @param activityInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/withdraw")
	public HashMap<String, Object> withdrawActivity(HttpServletRequest request){
		HashMap<String, Object> return_data = new HashMap<String, Object>();
		String activityIdString=request.getParameter("activityId");
		String userIdString=request.getParameter("userId");
		int userid = userIdDecoder.getUserId(userIdString);
		logger.info("userid = " + String.valueOf(userid));
		int activityId=0; int userId=0;
		try{
			activityId=Integer.parseInt(activityIdString);
			userId=Integer.parseInt(userIdString);
		}catch(Exception ex){
			ex.printStackTrace();
			return return_data;
		}
		if (activiyService.withdrawActivity(activityId,userId)){
			return_data.put("errMsg", "ok");
		}
		else {
			return_data.put("errMsg", "withdraw fail");
		}
		return_data.put("data", new ArrayList<String>());
		return return_data;
	}

}
