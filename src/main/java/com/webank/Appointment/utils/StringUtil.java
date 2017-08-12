package com.webank.Appointment.utils;

/**
 * 
 * @author johnnyliang
 *
 */
public class StringUtil {
	public static boolean isEmptyOrBlank(String str){
		if (str == null){
			return true;
		}
		if (str.isEmpty() || str.trim().isEmpty()){
			return true;
		}
		return false;
	}
}
