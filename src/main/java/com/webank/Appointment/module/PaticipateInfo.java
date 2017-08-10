package com.webank.Appointment.module;

import java.sql.Timestamp;

/**
 * @author 
 * @date 
 */
public class PaticipateInfo {

	private int paticipate;//参与Id
	private int activityId;//活动Id
	private int userId;//用户Id
	private int number;//报名人数
	private Timestamp paticipateTime;//报名时间
	/**
	 * @return the paticipate
	 */
	public int getPaticipate() {
		return paticipate;
	}
	/**
	 * @param paticipate the paticipate to set
	 */
	public void setPaticipate(int paticipate) {
		this.paticipate = paticipate;
	}
	/**
	 * @return the activityId
	 */
	public int getActivityId() {
		return activityId;
	}
	/**
	 * @param activityId the activityId to set
	 */
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the paticipateTime
	 */
	public Timestamp getPaticipateTime() {
		return paticipateTime;
	}
	/**
	 * @param paticipateTime the paticipateTime to set
	 */
	public void setPaticipateTime(Timestamp paticipateTime) {
		this.paticipateTime = paticipateTime;
	}

	
	
}