/**
 * 
 */
package com.webank.Appointment.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webank.Appointment.module.PersonInfo;

/**
 * @author shawphychen
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
public class PersonInfoDaoTest {
	@Autowired
	private PersonInfoDao personInfoDao;
	
	private PersonInfo getPersonInfo(){
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1);
		personInfo.setOpenId("1234567890");
		personInfo.setGender(1);
		personInfo.setPhonenumber("15992439943");
		personInfo.setUsername("陈小锋");
		return personInfo;
	}
	
	/**
	 * Test method for {@link com.webank.Appointment.dao.PersonInfoDao#addPerson(com.webank.Appointment.module.PersonInfo)}.
	 */
	@Test
	public void testAddPerson() {
		int expected=1;
		int actual = personInfoDao.addPerson(getPersonInfo());
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.PersonInfoDao#getPersonById(int)}.
	 */
	@Test
	public void testGetPersonById() {
		PersonInfo expected=getPersonInfo();
		PersonInfo actual=personInfoDao.getPersonById(expected.getUserId());
		assertEquals(expected.getUserId(),actual.getUserId());
		assertTrue(expected.getGender()==actual.getGender());
		assertTrue(expected.getPhonenumber().equals(actual.getPhonenumber()));
		assertTrue(expected.getUsername().equals(actual.getUsername()));
		
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.PersonInfoDao#getPersonByName(java.lang.String)}.
	 */
	@Test
	public void testGetPersonByName() {
		PersonInfo expected=getPersonInfo();
		int count=1;
		List<PersonInfo> actual=personInfoDao.getPersonByName(expected.getUsername());
		assertEquals(count, actual.size());
		assertEquals(expected.getUserId(),actual.get(0).getUserId());
		assertTrue(expected.getGender()==actual.get(0).getGender());
		assertTrue(expected.getPhonenumber().equals(actual.get(0).getPhonenumber()));
		assertTrue(expected.getUsername().equals(actual.get(0).getUsername()));
		
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.PersonInfoDao#getPersonByPhone(java.lang.String)}.
	 */
	@Test
	public void testGetPersonByPhone() {
		PersonInfo expected=getPersonInfo();
		PersonInfo actual=personInfoDao.getPersonByPhone(expected.getPhonenumber());
		assertEquals(expected.getUserId(),actual.getUserId());
		assertTrue(expected.getGender()==actual.getGender());
		assertTrue(expected.getPhonenumber().equals(actual.getPhonenumber()));
		assertTrue(expected.getUsername().equals(actual.getUsername()));
		
	}


	private PersonInfo getModifiedPersonInfo(){
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1);
		personInfo.setGender(0);
		personInfo.setPhonenumber("15992439942");
		personInfo.setUsername("陈小锋1");
		return personInfo;
	}
	/**
	 * Test method for {@link com.webank.Appointment.dao.PersonInfoDao#modifyPerson(com.webank.Appointment.module.PersonInfo)}.
	 */
	@Test
	public void testModifyPerson() {
		PersonInfo expected=getModifiedPersonInfo();
		PersonInfo actual=personInfoDao.getPersonById(expected.getUserId());
		actual.setGender(0);
		actual.setPhonenumber("15992439942");
		actual.setUsername("陈小锋1");
		int count =personInfoDao.modifyPerson(actual);
		assertEquals(count, 1);
		actual=personInfoDao.getPersonById(expected.getUserId());
		assertEquals(expected.getUserId(),actual.getUserId());
		assertTrue(expected.getGender()==actual.getGender());
		assertTrue(expected.getPhonenumber().equals(actual.getPhonenumber()));
		assertTrue(expected.getUsername().equals(actual.getUsername()));
		
	}

	/**
	 * Test method for {@link com.webank.Appointment.dao.PersonInfoDao#deletePerson(int)}.
	 */
	@Test
	public void testDeletePerson() {
		int expected=1;
		int actual=personInfoDao.deletePerson(1);
		assertEquals(expected, actual);
	}
}
