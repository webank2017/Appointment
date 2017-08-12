package com.webank.Appointment.module;

import java.sql.Timestamp;

/**
 * @author 
 * @date 
 */
public class PaticipateInfo {

	private int paticipate;//参与Id
	private int activityId;//活动Id
	private String username;//用户姓名
	private int userId;//用户Id
	private String phone;//用户电话
	private int gender;//性别
	private int number;//报名人数
	private Timestamp paticipateTime;//报名时间
	
	
	
	
	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
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