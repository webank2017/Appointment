package com.webank.Appointment.module;

import java.sql.Timestamp;

/**
 * @author 
 * @date 
 */
public class PersonInfo {

	private int userId;//'主键'
	private String openId; //openId
	private String username;//'用户姓名'
	private int gender;//'性别 1:男 0:女'
	private String phonenumber;// '电话号码'
	
	
	
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @return the user_id
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
}