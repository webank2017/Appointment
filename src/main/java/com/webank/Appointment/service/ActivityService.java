package com.webank.Appointment.service;

import java.util.List;

import com.webank.Appointment.controller.common.Page;
import com.webank.Appointment.module.ActivityInfo;
import com.webank.Appointment.module.PaticipateInfo;
import com.webank.Appointment.module.PersonInfo;

/**
 * @author 
 * @date 
 */

public interface ActivityService {

	Page<ActivityInfo> getActivityList(int pageNo, int pageSize,
			int userId);

	ActivityInfo getActivity(int activityId);

	List<PersonInfo> getJoiner(int activityId);

	List<ActivityInfo> getActivityByUId(int userId);

	List<ActivityInfo> getMyPaticipate(int userId);

	boolean addActivity(ActivityInfo activityInfo);

	boolean join(PaticipateInfo paticipateInfo);

	boolean withdrawActivity(int activityId, int userId);
	
}
