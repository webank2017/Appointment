package com.webank.Appointment.utils;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 
 * desc:系统启动后 启动socket线程
 * 
 * @author chenxiaofeng(2016年9月1日)
 */
@Component
public class YBSession implements  ApplicationListener<ContextRefreshedEvent>
{
	private static final Logger logger=Logger.getLogger(YBSession.class);
	public static Map<String,String> session=new HashMap<String,String>();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		 if (event.getApplicationContext().getParent() == null) {
			 logger.info("若已开启 先关闭socket线程!");
			 logger.info("启动socket线程!");
	        }
		
	}

}
