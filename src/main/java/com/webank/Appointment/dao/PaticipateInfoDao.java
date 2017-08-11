
package com.webank.Appointment.dao;

import java.util.List;

import com.webank.Appointment.module.PaticipateInfo;

/**
 * @author 
 * @date 
 */

public interface PaticipateInfoDao {
	
	
	//---------------------------查找
	

	/**
	 * 通过活动Id和用户Id获取
	 * @param activityId
	 * @param userId
	 * @return
	 */
	PaticipateInfo getPaticipateByActiIdUid(int activityId,int userId);
	
	/**
	 * 通过活动Id获取
	 * @param ActivityId
	 * @return
	 */
	List<PaticipateInfo> getPaticipateByActiId(int activityId);
	

	/**
	 * 通过用户Id获取
	 * @param userId
	 * @return
	 */
	List<PaticipateInfo> getPaticipateByUserId(int userId);
	
	
	//--------------------------- 增加
	

	/**
	 * 参加活动
	 * @param paticipateInfo
	 * @return
	 */
	int addPaticipateInfo(PaticipateInfo paticipateInfo);
	//---------------------------删除
	
	
	/**
	 * 退出活动
	 * @param activityId
	 * @param userId
	 * @return
	 */
	int deletePaticipateInfo(int activityId,int userId);

	//---------------------------修改
	

	/**
	 * 修改参与信息
	 * @param activityId
	 * @return
	 */
	int modifyPaticipateInfo(PaticipateInfo paticipateInfo);
	
	
}
