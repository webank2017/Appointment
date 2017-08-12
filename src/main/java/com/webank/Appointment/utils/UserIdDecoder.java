package com.webank.Appointment.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webank.Appointment.module.PersonInfo;
import com.webank.Appointment.service.UserService;

@Service
public class UserIdDecoder {
	@Autowired
	private UserService userService;
	
	public int getUserId(HttpSession session, String thirdSession){
		String openid = SessionUtil.getOpenId(session, thirdSession);
		if (openid == null){
			return -1;
		}
		PersonInfo personInfo = userService.getUserByOpenid(openid);
		if (personInfo == null){
			return -1;
		}
		return personInfo.getUserId();
	}
}
