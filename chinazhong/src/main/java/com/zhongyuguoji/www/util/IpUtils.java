package com.zhongyuguoji.www.util;

import java.security.SecureRandom;

public final class IpUtils {

	private IpUtils() {
		super();
	}

	public static String randIP() {
		SecureRandom random = new SecureRandom();
		return (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "." + (random.nextInt(255) + 1) + "."
				+ (random.nextInt(255) + 1);
	}
}
