/**
 * 
 */
package com.webank.Appointment.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author johnnyliang
 *
 */
public class SessionUtil {
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
}
