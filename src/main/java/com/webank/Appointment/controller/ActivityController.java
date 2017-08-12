/**
 *  @Title: Test.java 
 *  @Package com.cn21.FrequencyControl 
 *  @Description: TODO(用一句话描述该文件做什么) 
 *  @author chenxiaofeng
 *  @date 2016年8月8日 下午5:21:52 
 *  @version V1.0 
 */
package com.webank.Appointment.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String activityList(@PathVariable int userId,HttpServletRequest request, HttpServletResponse respons) {
		Page<ActivityInfo> activityList=activiyService.getActivityList(Page.DEFAULT_PAGE_NO,Page.DEFAULT_PAGE_SIZE,userId);
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
	@RequestMapping(value = "/detail/{userId}/{activityId}")
	@ResponseBody
	public String activityDetail(@PathVariable int userId,@PathVariable int activityId,HttpServletRequest request, HttpServletResponse respons) {
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
	public String MyActivity(@PathVariable int userId,HttpServletRequest request, HttpServletResponse respons) {
		List<ActivityInfo> activity=activiyService.getActivityByUId(userId);
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
	public String MyPaticipate(@PathVariable int userId,HttpServletRequest request, HttpServletResponse respons) {
		List<ActivityInfo> activity=activiyService.getMyPaticipate(userId);
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
	public Map<String,Object> joinActivity(HttpServletRequest request, HttpServletResponse respons,PaticipateInfo paticipateInfo) {
		HashMap<String, Object> return_data = new HashMap<String, Object>();

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
	 */
	@ResponseBody
	@RequestMapping(value = "launch")
	public HashMap<String, Object> launchAct(HttpServletRequest request, String thirdSession, ActivityInfo activityInfo){
		HashMap<String, Object> return_data = new HashMap<String, Object>();
		activityInfo.setActivityState(0);
		Date nowDate = new Date();
		activityInfo.setLaunchTime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(nowDate));
		activityInfo.setNumberNow(0);
		int userid = userIdDecoder.getUserId(request.getSession(), thirdSession);
		
		logger.info("ThirdSession to UserId: [thirdSession=" + thirdSession + "][userid="+String.valueOf(userid));
		
		if (userid >= 0){
			activityInfo.setUserId(userid);
			if (activiyService.addActivity(activityInfo)){
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
		int activityId=0; int userId=0;
		try{
			activityId=Integer.parseInt(activityIdString);
			userId=Integer.parseInt(userIdString);
		}catch(Exception ex){
			return_data.put("errMsg", "withdraw fail");
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
