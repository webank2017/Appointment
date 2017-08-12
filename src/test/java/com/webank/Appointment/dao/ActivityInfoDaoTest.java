/**
 * 
 */
package com.webank.Appointment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webank.Appointment.module.ActivityInfo;

/**
 * @author shawphychen
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
public class ActivityInfoDaoTest {
	@Autowired
	private ActivityInfoDao activityInfoDao;

	private ActivityInfo getActivityInfo(){
		ActivityInfo activityInfo = new ActivityInfo();
		activityInfo.setActivityId(3);
		activityInfo.setActivityInfo("打篮球打篮球打篮球打篮球打篮球打篮球打篮球");
		activityInfo.setActivityPlace("微众大厦");
		activityInfo.setActivityPlace_x(12.01);
		activityInfo.setActivityPlace_y(13.08);
		activityInfo.setActivityState(1);
		activityInfo.setActivityTheme("篮球");
		activityInfo.setActivityType(0);
		activityInfo.setComments("搞起来");
		activityInfo.setContacter("陈小锋");
		activityInfo.setContacterNumber("15992439943");
		activityInfo.setDetailPlace("前海生态科技园");
		activityInfo.setEndTime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		activityInfo.setGenderRequire(2);
		activityInfo.setIfRequire(0);
		activityInfo.setLaunchTime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		activityInfo.setNumberNow(1);
		activityInfo.setNumberUp(10);
		activityInfo.setPassword("66666");
		activityInfo.setStartTime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		activityInfo.setUserId(1);
		return activityInfo;
	}
	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#addActivity(com.webank.Appointment.module.ActivityInfo)}.
	 */
	@Test
	public void testAddActivity() {
		int expected=1;
		ActivityInfo activityInfo = getActivityInfo();
		int actual=activityInfoDao.addActivity(activityInfo);
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivityById(int)}.
	 */
	@Test
	public void testGetActivityById() {
		ActivityInfo expected = getActivityInfo();
		ActivityInfo actual = activityInfoDao.getActivityById(expected.getActivityId());
		assertTrue(expected.getActivityId()==actual.getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.getActivityType());
		assertTrue(expected.getComments().equals(actual.getComments()));
		assertTrue(expected.getContacter().equals(actual.getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.getIfRequire());
		assertTrue(expected.getNumberNow()==actual.getNumberNow());
		assertTrue(expected.getNumberUp()==actual.getNumberUp());
		assertTrue(expected.getPassword().equals(actual.getPassword()));
		assertTrue(expected.getUserId()==actual.getUserId());
		
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByTheme(java.lang.String)}.
	 */
	@Test
	public void testGetActivitiesByTheme() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByTheme(expected.getActivityTheme());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
		
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByUserId(int)}.
	 */
	@Test
	public void testGetActivitiesByUserId() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByUserId(expected.getUserId());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByTime(java.sql.Timestamp, java.sql.Timestamp)}.
	 */
	@Test
	public void testGetActivitiesByTime() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByType(int)}.
	 */
	@Test
	public void testGetActivitiesByType() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByType(expected.getActivityType());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByPlace(java.lang.String)}.
	 */
	@Test
	public void testGetActivitiesByPlace() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByPlace(expected.getActivityPlace());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByXY(double, double)}.
	 */
	@Test
	public void testGetActivitiesByXY() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByXY(expected.getActivityPlace_x(),expected.getActivityPlace_y());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByDesc(java.lang.String)}.
	 */
	@Test
	public void testGetActivitiesByDesc() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByDesc(expected.getActivityInfo());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByState(int)}.
	 */
	@Test
	public void testGetActivitiesByState() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByState(expected.getActivityState());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByThemeState(java.lang.String, int)}.
	 */
	@Test
	public void testGetActivitiesByThemeState() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByThemeState(expected.getActivityTheme(), expected.getActivityState());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByUserIdState(int, int)}.
	 */
	@Test
	public void testGetActivitiesByUserIdState() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByUserIdState(expected.getUserId(), expected.getActivityState());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByTimeState(java.sql.Timestamp, java.sql.Timestamp, int)}.
	 */
	@Test
	public void testGetActivitiesByTimeState() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByTypeState(int, int)}.
	 */
	@Test
	public void testGetActivitiesByTypeState() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByTypeState(expected.getActivityType(), expected.getActivityState());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByPlaceState(java.lang.String, int)}.
	 */
	@Test
	public void testGetActivitiesByPlaceState() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByPlaceState(expected.getActivityPlace(), expected.getActivityState());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByXYState(double, double, int)}.
	 */
	@Test
	public void testGetActivitiesByXYState() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByXYState(expected.getActivityPlace_x(),expected.getActivityPlace_y(), expected.getActivityState());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#getActivitiesByDescState(java.lang.String, int)}.
	 */
	@Test
	public void testGetActivitiesByDescState() {
		ActivityInfo expected = getActivityInfo();
		List<ActivityInfo> actual = activityInfoDao.getActivitiesByDescState(expected.getActivityInfo(), expected.getActivityState());
		int count=1;
		assertEquals(count,actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.get(0).getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.get(0).getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.get(0).getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.get(0).getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.get(0).getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.get(0).getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.get(0).getActivityType());
		assertTrue(expected.getComments().equals(actual.get(0).getComments()));
		assertTrue(expected.getContacter().equals(actual.get(0).getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.get(0).getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.get(0).getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.get(0).getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.get(0).getIfRequire());
		assertTrue(expected.getNumberNow()==actual.get(0).getNumberNow());
		assertTrue(expected.getNumberUp()==actual.get(0).getNumberUp());
		assertTrue(expected.getPassword().equals(actual.get(0).getPassword()));
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	private ActivityInfo getModifyActivityInfo(){
		ActivityInfo activityInfo = new ActivityInfo();
		activityInfo.setActivityId(3);
		activityInfo.setActivityInfo("打篮球打篮球打篮球打篮球打篮球打篮球打篮球1");
		activityInfo.setActivityPlace("微众大厦1");
		activityInfo.setActivityPlace_x(12.011);
		activityInfo.setActivityPlace_y(13.081);
		activityInfo.setActivityState(0);
		activityInfo.setActivityTheme("篮球1");
		activityInfo.setActivityType(1);
		activityInfo.setComments("搞起来1");
		activityInfo.setContacter("陈小锋1");
		activityInfo.setContacterNumber("15992439942");
		activityInfo.setDetailPlace("前海生态科技园1");
		activityInfo.setEndTime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		activityInfo.setGenderRequire(1);
		activityInfo.setIfRequire(1);
		activityInfo.setLaunchTime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		activityInfo.setNumberNow(2);
		activityInfo.setNumberUp(12);
		activityInfo.setPassword("666661");
		activityInfo.setStartTime((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()));
		activityInfo.setUserId(1);
		return activityInfo;
	}
	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#modifyActivity(com.webank.Appointment.module.ActivityInfo)}.
	 */
	@Test
	public void testModifyActivity() {
		ActivityInfo expected = getModifyActivityInfo();
		ActivityInfo actual = activityInfoDao.getActivityById(expected.getActivityId());
		actual.setActivityInfo(expected.getActivityInfo());
		actual.setActivityInfo(expected.getActivityInfo());
		actual.setActivityPlace(expected.getActivityPlace());
		actual.setActivityPlace_x(expected.getActivityPlace_x());
		actual.setActivityPlace_y(expected.getActivityPlace_y());
		actual.setActivityState(expected.getActivityState());
		actual.setActivityTheme(expected.getActivityTheme());
		actual.setActivityType(expected.getActivityType());
		actual.setComments(expected.getComments());
		actual.setContacter(expected.getContacter());
		actual.setContacterNumber(expected.getContacterNumber());
		actual.setDetailPlace(expected.getDetailPlace());
		actual.setGenderRequire(expected.getGenderRequire());
		actual.setIfRequire(expected.getIfRequire());
		actual.setNumberNow(expected.getNumberNow());
		actual.setNumberUp(expected.getNumberUp());
		actual.setPassword(expected.getPassword());
		int count=activityInfoDao.modifyActivity(actual);
		assertEquals(1,count);
		actual=activityInfoDao.getActivityById(expected.getActivityId());
		assertTrue(expected.getActivityId()==actual.getActivityId());
		assertTrue(expected.getActivityInfo().equals(actual.getActivityInfo()));
		assertTrue(expected.getActivityPlace().equals(actual.getActivityPlace()));
		assertTrue(expected.getActivityPlace_x()-actual.getActivityPlace_x()<0.0000001);
		assertTrue(expected.getActivityPlace_y()-actual.getActivityPlace_y()<0.0000001);
		assertTrue(expected.getActivityState()==actual.getActivityState());
		assertTrue(expected.getActivityTheme().equals(actual.getActivityTheme()));
		assertTrue(expected.getActivityType()==actual.getActivityType());
		assertTrue(expected.getComments().equals(actual.getComments()));
		assertTrue(expected.getContacter().equals(actual.getContacter()));
		assertTrue(expected.getContacterNumber().equals(actual.getContacterNumber()));
		assertTrue(expected.getDetailPlace().equals(actual.getDetailPlace()));
		assertTrue(expected.getGenderRequire()==actual.getGenderRequire());
		assertTrue(expected.getIfRequire()==actual.getIfRequire());
		assertTrue(expected.getNumberNow()==actual.getNumberNow());
		assertTrue(expected.getNumberUp()==actual.getNumberUp());
		assertTrue(expected.getPassword().equals(actual.getPassword()));
		assertTrue(expected.getUserId()==actual.getUserId());
		
	}
	
	/**
	 * Test method for {@link com.webank.Appointment.dao.ActivityInfoDao#deleteActivitiesById(int)}.
	 */
	@Test
	public void testDeleteActivitiesById() {
		int expected=1;
		ActivityInfo activityInfo = getActivityInfo();
		int actual=activityInfoDao.deleteActivitiesById(activityInfo.getActivityId());
		assertEquals(expected,actual);
		
	}

}
