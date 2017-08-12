package com.webank.Appointment.module;

import java.sql.Timestamp;

/**
 * @author 
 * @date 
 */
public class ActivityInfo {

	private int activityId;//活动Id
	private String activityTheme;//活动主题
	private int userId;//用户Id
	private String launchTime;//'活动发布时间',
	private String startTime ;// '活动开始时间',
	private String endTime ;// '活动结束时间',
	private int activityType; //活动类型 '0体育，1旅游，2户外，3娱乐，4其他',
	private String activityPlace; //'活动地址名',
	private	  String detailPlace; // '活动详细地址',
	private  double activityPlace_x; // '活动地址坐标x',
	private  double activityPlace_y;//'活动地址坐标y',
	private  int numberNow ;// '当前报名人数',
	private  int numberUp ;// '活动人数上限',
	private  String activityInfo ;// '活动描述',
	private  String contacter;// '联系人',
	private  String contacterNumber ;// '联系人电话',
	private  int genderRequire;//'性别要求，0只女性，1只男性，2不限',
	private  int activityState;//'活动状态 0已结束，1正在进行，2已取消',
	private  int ifRequire ;// '参与条件 0无限制，1需要参与码',
	private  String password;// '参与码',
	private  String comments ;//'备注',
	
	
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
	 * @return the activityTheme
	 */
	public String getActivityTheme() {
		return activityTheme;
	}
	/**
	 * @param activityTheme the activityTheme to set
	 */
	public void setActivityTheme(String activityTheme) {
		this.activityTheme = activityTheme;
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
	 * @return the launchTime
	 */
	public String getLaunchTime() {
		return launchTime;
	}
	/**
	 * @param launchTime the launchTime to set
	 */
	public void setLaunchTime(String launchTime) {
		this.launchTime = launchTime;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endtime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endtime the endtime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the activityType
	 */
	public int getActivityType() {
		return activityType;
	}
	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	/**
	 * @return the activityPlace
	 */
	public String getActivityPlace() {
		return activityPlace;
	}
	/**
	 * @param activityPlace the activityPlace to set
	 */
	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}
	/**
	 * @return the detailplace
	 */
	public String getDetailPlace() {
		return detailPlace;
	}
	/**
	 * @param detailplace the detailplace to set
	 */
	public void setDetailPlace(String detailPlace) {
		this.detailPlace = detailPlace;
	}
	/**
	 * @return the activityplace_x
	 */
	public double getActivityPlace_x() {
		return activityPlace_x;
	}
	/**
	 * @param activityplace_x the activityplace_x to set
	 */
	public void setActivityPlace_x(double activityPlace_x) {
		this.activityPlace_x = activityPlace_x;
	}
	/**
	 * @return the activityplace_y
	 */
	public double getActivityPlace_y() {
		return activityPlace_y;
	}
	/**
	 * @param activityplace_y the activityplace_y to set
	 */
	public void setActivityPlace_y(double activityPlace_y) {
		this.activityPlace_y = activityPlace_y;
	}
	/**
	 * @return the numbernow
	 */
	public int getNumberNow() {
		return numberNow;
	}
	/**
	 * @param numbernow the numbernow to set
	 */
	public void setNumberNow(int numberNow) {
		this.numberNow = numberNow;
	}
	/**
	 * @return the numberup
	 */
	public int getNumberUp() {
		return numberUp;
	}
	/**
	 * @param numberup the numberup to set
	 */
	public void setNumberUp(int numberUp) {
		this.numberUp = numberUp;
	}
	/**
	 * @return the activityinfo
	 */
	public String getActivityInfo() {
		return activityInfo;
	}
	/**
	 * @param activityinfo the activityinfo to set
	 */
	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo;
	}
	/**
	 * @return the contacter
	 */
	public String getContacter() {
		return contacter;
	}
	/**
	 * @param contacter the contacter to set
	 */
	public void setContacter(String contacter) {
		this.contacter = contacter;
	}
	/**
	 * @return the contacternumber
	 */
	public String getContacterNumber() {
		return contacterNumber;
	}
	/**
	 * @param contacternumber the contacternumber to set
	 */
	public void setContacterNumber(String contacterNumber) {
		this.contacterNumber = contacterNumber;
	}
	/**
	 * @return the genderrequire
	 */
	public int getGenderRequire() {
		return genderRequire;
	}
	/**
	 * @param genderrequire the genderrequire to set
	 */
	public void setGenderRequire(int genderRequire) {
		this.genderRequire = genderRequire;
	}
	/**
	 * @return the activitystate
	 */
	public int getActivityState() {
		return activityState;
	}
	/**
	 * @param activitystate the activitystate to set
	 */
	public void setActivityState(int activityState) {
		this.activityState = activityState;
	}
	/**
	 * @return the ifrequire
	 */
	public int getIfRequire() {
		return ifRequire;
	}
	/**
	 * @param ifrequire the ifrequire to set
	 */
	public void setIfRequire(int ifRequire) {
		this.ifRequire = ifRequire;
	}
	/**
	 * @return the pASSWORD
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}


	
}