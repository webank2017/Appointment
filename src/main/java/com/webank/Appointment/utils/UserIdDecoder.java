package com.webank.Appointment.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webank.Appointment.module.PersonInfo;
import com.webank.Appointment.service.UserService;
import com.webank.Appointment.service.impl.UserServiceImpl;

@Service
public class UserIdDecoder {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserService userService;
	
	public int getUserId(String thirdSession){
		logger.info("------------------------------------------");
		
		String key = YBSession.session.get(thirdSession);
		String openid = SessionUtil.getOpenId(key);
		
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
