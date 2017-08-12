/**
 * 
 */
package com.webank.Appointment.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.webank.Appointment.controller.ActivityController;

/**
 * @author johnnyliang
 *
 */
public class SessionUtil {
	private static Logger logger = Logger.getLogger(SessionUtil.class);
	/**
	 * 设置session
	 * @param session
	 * @param key
	 * @param value
	 */
	public static void setAttribute(HttpSession session, String key, String value){
		session.setAttribute(key, value);
	}
	
	/**
	 * 从session中移除某个键值
	 * @param session
	 * @param key
	 */
	public static void removeAttribute(HttpSession session, String key){
		session.removeAttribute(key);
	}
	
	/**
	 * 判断session中是否存在某个键值
	 * @param session
	 * @param key
	 * @return
	 */
	public static boolean isExist(HttpSession session, String key){
		Object valueString = session.getAttribute(key);
		if (valueString == null || StringUtil.isEmptyOrBlank(valueString.toString())){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Object getAttrivute(HttpSession session, String key){
		return session.getAttribute(key);
	}
	
	/**
	 * 通过thirdSession获取用户的openid
	 * @param session
	 * @param key
	 * @return
	 */
	public static String getOpenId(String key){
		
		if (key == null || StringUtil.isEmptyOrBlank(key.toString())){
			return null;
		}


		String[] items = key.split(",");
		logger.info("sesskey="+String.valueOf(items[0]));
		logger.info("openid="+String.valueOf(items[1]));
		if (items != null && items.length == 2){
			return items[1];
		}
		else {
			return null;
		}
	}
}
