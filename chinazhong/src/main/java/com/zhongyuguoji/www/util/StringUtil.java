package com.zhongyuguoji.www.util;

public class StringUtil {
	public static boolean isNullOrEmpty(String strIn) {
		if (strIn == null || strIn.length() == 0 || strIn.trim().equalsIgnoreCase("null")) {
			return true;
		}
		return false;
	}
}
