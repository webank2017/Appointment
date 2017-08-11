/**
 *  @Title: Test.java 
 *  @Package com.cn21.FrequencyControl 
 *  @Description: TODO(用一句话描述该文件做什么) 
 *  @author chenxiaofeng
 *  @date 2016年8月8日 下午5:21:52 
 *  @version V1.0 
 */
package com.webank.Appointment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webank.Appointment.service.ActivityService;


/**
 * @author 
 * @date 
 */
@Controller
@RequestMapping("/")
public class MainController {
	/**
	 * 欢迎页面
	 * @return void
	 */
	@Autowired
	protected ActivityService userService;
	@RequestMapping(value = "")
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse respons) {
		ModelAndView modelAndView = new ModelAndView("/welcome");
		return modelAndView;
	}

}
