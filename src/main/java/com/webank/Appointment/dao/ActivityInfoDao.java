
package com.webank.Appointment.dao;

import java.sql.Timestamp;
import java.util.List;

import com.webank.Appointment.module.ActivityInfo;

/**
 * @author 
 * @date 
 */

public interface ActivityInfoDao {
	
	/**
	 * 获取我参加的活动
	 * @param userId
	 * @return
	 */
	List<ActivityInfo> getMyPaticipate(int userId);
	
	int getTotal(Timestamp time);
	
	List<ActivityInfo> queryByRange(int offset,int pageSize,Timestamp time);
	
	
	//---------------------------不分状态 结束：正在进行
	
	/**
	 * 通过活动id获取
	 * @param activityId
	 * @return
	 */
	ActivityInfo getActivityById(int activityId);
	
	/**
	 * 通过活动主题获取
	 * @param theme
	 * @return
	 */
	List<ActivityInfo> getActivitiesByTheme(String theme);
	
	/**
	 * 通过用户Id获取
	 * @param userId
	 * @return
	 */
	List<ActivityInfo> getActivitiesByUserId(int userId);
	
	/**
	 * 通过时间区域获取
	 * @param from
	 * @param to
	 * @return
	 */
	List<ActivityInfo> getActivitiesByTime(Timestamp from,Timestamp to);
	
	/**
	 * 通过类型获取
	 * @param type
	 * @return
	 */
	List<ActivityInfo> getActivitiesByType(int type);
	
	/**
	 * 通过地点获取
	 * @param place
	 * @return
	 */
	List<ActivityInfo> getActivitiesByPlace(String place);
	
	/**
	 * 通过坐标获取
	 * @param x
	 * @param y
	 * @return
	 */
	List<ActivityInfo> getActivitiesByXY(double x,double y);
	
	/**
	 * 通过描述获取
	 * @param desc
	 * @return
	 */
	List<ActivityInfo> getActivitiesByDesc(String desc);
	
	/**
	 * 通过状态获取
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByState(int state);
	
	//---------------------------分状态
	
	/**
	 * 通过主题和状态获取
	 * @param theme
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByThemeState(String theme,int state);
	
	/**
	 * 通过用户Id和状态获取
	 * @param userId
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByUserIdState(int userId,int state);
	
	/**
	 * 通过时间和状态获取
	 * @param from
	 * @param to
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByTimeState(Timestamp from,Timestamp to,int state);
	
	/**
	 * 通过类型和状态获取
	 * @param type
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByTypeState(int type,int state);
	
	/**
	 * 通过地点和状态获取
	 * @param place
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByPlaceState(String place,int state);
	
	/**
	 * 通过坐标和状态获取
	 * @param x
	 * @param y
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByXYState(double x,double y,int state);
	
	/**
	 * 通过描述和状态获取
	 * @param desc
	 * @param state
	 * @return
	 */
	List<ActivityInfo> getActivitiesByDescState(String desc,int state);
	
	//--------------------------- 增加
	
	/**
	 * 添加活动
	 * @param activity
	 * @return
	 */
	int addActivity(ActivityInfo activity);
	//---------------------------删除
	
	
	/**
	 * 删除活动
	 * @param id
	 * @return
	 */
	int deleteActivitiesById(int id);

	//---------------------------修改
	
	/**
	 * 修改活动
	 * @param activityId
	 * @return
	 */
	int modifyActivity(ActivityInfo activity);
	
	
	
}
