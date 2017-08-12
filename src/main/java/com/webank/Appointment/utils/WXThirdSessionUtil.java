package com.webank.Appointment.utils;

import java.security.SecureRandom;
import java.util.UUID;

public class WXThirdSessionUtil {
	public static String generate(String seed){
		return UUID.randomUUID().toString();
	}
}
