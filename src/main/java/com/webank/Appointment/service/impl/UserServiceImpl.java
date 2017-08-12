package com.webank.Appointment.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webank.Appointment.controller.UserController;
import com.webank.Appointment.dao.PersonInfoDao;
import com.webank.Appointment.module.PersonInfo;
import com.webank.Appointment.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private PersonInfoDao personInfoDao;
	public boolean addUser(PersonInfo userInfo){
		try {
			personInfoDao.addPerson(userInfo);
			return true;
		}
		catch (Exception exception){
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * 判断一个用户是否已经入库
	 */
	public boolean isExist(String openid){
		try {
			PersonInfo person = personInfoDao.getPersonByOpenId(openid);
			if (person == null){
				return false;
			}
			else {
				return true;
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
			logger.error(ex.toString());
			return false;
		}
	}
}
