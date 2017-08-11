/**
 * 
 */
package com.webank.Appointment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webank.Appointment.module.PaticipateInfo;

/**
 * @author shawphychen
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
public class PaticipateInfoDaoTest {
	
	@Autowired
	private PaticipateInfoDao paticipateInfoDao;
	private PaticipateInfo getPaticipateInfo(){
		PaticipateInfo paticipateInfo = new PaticipateInfo();
		paticipateInfo.setActivityId(1);
		paticipateInfo.setNumber(1);
		paticipateInfo.setPaticipate(1);
		paticipateInfo.setPaticipateTime(new Timestamp(System.currentTimeMillis()));
		paticipateInfo.setUserId(1);
		return paticipateInfo;
	}
	/**
	 * Test method for {@link com.webank.Appointment.dao.PaticipateInfoDao#addPaticipateInfo(com.webank.Appointment.module.PaticipateInfo)}.
	 */
	@Test
	public void testAddPaticipateInfo() {
		int expected=1;
		int actual=paticipateInfoDao.addPaticipateInfo(getPaticipateInfo());
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link com.webank.Appointment.dao.PaticipateInfoDao#getPaticipateByActiIdUid(int, int)}.
	 */
	@Test
	public void testGetPaticipateByActiIdUid() {
		PaticipateInfo expected=getPaticipateInfo();
		PaticipateInfo actual=paticipateInfoDao.getPaticipateByActiIdUid(expected.getActivityId(), expected.getUserId());
		assertTrue(expected.getActivityId()==actual.getActivityId());
		assertTrue(expected.getNumber()==actual.getNumber());
		assertTrue(expected.getPaticipate()==actual.getPaticipate());
		assertTrue(expected.getUserId()==actual.getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.PaticipateInfoDao#getPaticipateByActiId(int)}.
	 */
	@Test
	public void testGetPaticipateByActiId() {
		PaticipateInfo expected=getPaticipateInfo();
		int count=1;
		List<PaticipateInfo> actual=paticipateInfoDao.getPaticipateByActiId(expected.getActivityId());
		assertEquals(count, actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getNumber()==actual.get(0).getNumber());
		assertTrue(expected.getPaticipate()==actual.get(0).getPaticipate());
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.PaticipateInfoDao#getPaticipateByUserId(int)}.
	 */
	@Test
	public void testGetPaticipateByUserId() {
		PaticipateInfo expected=getPaticipateInfo();
		int count=1;
		List<PaticipateInfo> actual=paticipateInfoDao.getPaticipateByUserId(expected.getUserId());
		assertEquals(count, actual.size());
		assertTrue(expected.getActivityId()==actual.get(0).getActivityId());
		assertTrue(expected.getNumber()==actual.get(0).getNumber());
		assertTrue(expected.getPaticipate()==actual.get(0).getPaticipate());
		assertTrue(expected.getUserId()==actual.get(0).getUserId());
	}

	private PaticipateInfo getModifiedPaticipateInfo(){
		PaticipateInfo paticipateInfo = new PaticipateInfo();
		paticipateInfo.setActivityId(1);
		paticipateInfo.setNumber(2);
		paticipateInfo.setPaticipate(1);
		paticipateInfo.setUserId(1);
		return paticipateInfo;
	}
	/**
	 * Test method for {@link com.webank.Appointment.dao.PaticipateInfoDao#modifyPaticipateInfo(com.webank.Appointment.module.PaticipateInfo)}.
	 */
	@Test
	public void testModifyPaticipateInfo() {
		PaticipateInfo expected=getModifiedPaticipateInfo();
		PaticipateInfo actual=paticipateInfoDao.getPaticipateByActiIdUid(expected.getActivityId(), expected.getUserId());
		actual.setNumber(2);
		int count=paticipateInfoDao.modifyPaticipateInfo(actual);
		assertEquals(count,1);
		actual=paticipateInfoDao.getPaticipateByActiIdUid(expected.getActivityId(), expected.getUserId());
		assertTrue(expected.getActivityId()==actual.getActivityId());
		assertTrue(expected.getUserId()==actual.getUserId());
		assertTrue(expected.getNumber()==actual.getNumber());
		assertTrue(expected.getPaticipate()==actual.getPaticipate());
		
	}

	
	/**
	 * Test method for {@link com.webank.Appointment.dao.PaticipateInfoDao#deletePaticipateInfo(int, int)}.
	 */
	@Test
	public void testDeletePaticipateInfo() {
		PaticipateInfo paticipateInfo = getPaticipateInfo();
		int expected=1;
		int actual=paticipateInfoDao.deletePaticipateInfo(paticipateInfo.getActivityId(), paticipateInfo.getUserId());
		assertEquals(expected,actual);
	}
}
