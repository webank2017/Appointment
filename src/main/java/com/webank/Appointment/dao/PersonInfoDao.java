
package com.webank.Appointment.dao;

import java.util.List;

import com.webank.Appointment.module.PersonInfo;

/**
 * @author 
 * @date 
 */

public interface PersonInfoDao {
	
	
	List<PersonInfo> getActivityJoiner(int activityId);
	
	
	//---------------------------查找
	

	/**
	 * 通过用户Id获取
	 * @param userId
	 * @return
	 */
	PersonInfo getPersonById(int userId);
	
	/**
	 * 通过openId获取
	 * @param openId
	 * @return
	 */
	PersonInfo getPersonByOpenId(String openId);
	
	int countPersonByOpenId(String openId);
	/**
	 * 通过名字获取
	 * @param Name
	 * @return
	 */
	List<PersonInfo> getPersonByName(String username);
	


	/**
	 * 通过电话获取
	 * @param phone
	 * @return
	 */
	PersonInfo getPersonByPhone(String phone);
	
	
	//--------------------------- 增加
	


	/**
	 * 增加用户
	 * @param Person
	 * @return
	 */
	int addPerson(PersonInfo Person);
	//---------------------------删除
	
	

	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	int deletePerson(int userId);

	//---------------------------修改
	


	/**
	 * 修改用户
	 * @param Person
	 * @return
	 */
	int modifyPerson(PersonInfo Person);
	
	
}
