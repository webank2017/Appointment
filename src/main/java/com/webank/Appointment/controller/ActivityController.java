/**
 *  @Title: Test.java 
 *  @Package com.cn21.FrequencyControl 
 *  @Description: TODO(用一句话描述该文件做什么) 
 *  @author chenxiaofeng
 *  @date 2016年8月8日 下午5:21:52 
 *  @version V1.0 
 */
package com.webank.Appointment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.webank.Appointment.controller.common.Page;
import com.webank.Appointment.module.ActivityInfo;
import com.webank.Appointment.module.PersonInfo;
import com.webank.Appointment.service.ActivityService;


/**
 * @author 
 * @date 
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

	
	@Autowired
	protected ActivityService activiyService;
	
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
	

}
