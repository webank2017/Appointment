package com.webank.Appointment.service;

import com.webank.Appointment.module.PersonInfo;

public interface UserService {
	boolean addUser(PersonInfo user);
	boolean isExist(String openid);
	PersonInfo getUserByOpenid(String openid);

}
