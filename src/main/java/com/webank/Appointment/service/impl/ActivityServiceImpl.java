package com.webank.Appointment.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webank.Appointment.controller.common.Page;
import com.webank.Appointment.dao.ActivityInfoDao;
import com.webank.Appointment.dao.PaticipateInfoDao;
import com.webank.Appointment.dao.PersonInfoDao;
import com.webank.Appointment.module.ActivityInfo;
import com.webank.Appointment.module.PaticipateInfo;
import com.webank.Appointment.module.PersonInfo;
import com.webank.Appointment.service.ActivityService;
/**
 * @author 
 * @date 
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
	private static Logger logger = Logger.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityInfoDao activityInfoDao;
	@Autowired
	private PersonInfoDao personInfoDao;
	@Autowired
	private PaticipateInfoDao paticipateInfoDao;

	@Override
	public Page<ActivityInfo> getActivityList(int pageNo, int pageSize,
			int userId) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		List<ActivityInfo> activityList = activityInfoDao.queryByRange(userId,(pageNo-1)*pageSize, pageSize, time);
		// TODO Auto-generated method stub
		int total = activityInfoDao.getTotal(time);
		Page<ActivityInfo> page = new Page<ActivityInfo>();
		page.setRecords(activityList);
		page.setMaxPage(total/pageSize+1);
		page.setPageSize(pageSize);
		page.setTotalSize(total);
		page.setPageNo(pageNo);
		return page;
	}

	@Override
	public ActivityInfo getActivity(int activityId) {
		// TODO Auto-generated method stub
		return activityInfoDao.getActivityById(activityId);
	}

	@Override
	public List<PersonInfo> getJoiner(int activityId) {
		// TODO Auto-generated method stub
		return personInfoDao.getActivityJoiner(activityId);
	}

	@Override
	public List<ActivityInfo> getActivityByUId(int userId) {
		// TODO Auto-generated method stub
		return activityInfoDao.getActivitiesByUserId(userId);
	}

	@Override
	public List<ActivityInfo> getMyPaticipate(int userId) {
		// TODO Auto-generated method stub
		return activityInfoDao.getMyPaticipate(userId);
	}
	
	@Override
	public boolean addActivity(ActivityInfo activityInfo){
		try {
			activityInfoDao.addActivity(activityInfo);
			return true;
		}
		catch (Exception ex){
			ex.printStackTrace();
			logger.error(ex.toString());
			return false;
		}
	}

	@Transactional
	@Override
	public boolean join(PaticipateInfo paticipateInfo) {
		// TODO Auto-generated method stub
		synchronized(ActivityServiceImpl.class){
			int remain = activityInfoDao.getRemain(paticipateInfo.getActivityId());
			if(remain==0) return false;
			if(activityInfoDao.increRemain(paticipateInfo.getActivityId())==1 && paticipateInfoDao.addPaticipateInfo(paticipateInfo)==1){
				return true;
			}
		}
		return false;
	}
	
	@Transactional
	@Override
	public boolean withdrawActivity(int activityId, int userId) {
		synchronized(ActivityServiceImpl.class){
			if(activityInfoDao.decreRemain(activityId)==1 && paticipateInfoDao.deletePaticipateInfo(activityId, userId)==1){
				return true;
			}
		}
		return false;
	}
	
}

  
