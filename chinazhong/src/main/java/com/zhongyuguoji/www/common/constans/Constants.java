package com.zhongyuguoji.www.common.constans;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

	private Constants() {
		super();
	}

	public static final class Failure {

		private Failure() {
			super();
		}

		public static final String COMMON_CODE = "310";
		public static final String IMAGE_CODE = "311";
		public static final Map<String, String> DESC = new HashMap<String, String>();

		static {
			DESC.put(COMMON_CODE, "操作失败");
			DESC.put(IMAGE_CODE, "验证码失败");

		}
	}

	public static final class Success {

		private Success() {
			super();
		}

		public static final String COMMON_CODE = "200";
		public static final String ACCOMPLISH = "201";
		public static final Map<String, String> DESC = new HashMap<String, String>();
		static {
			DESC.put(COMMON_CODE, "操作成功");
			DESC.put(ACCOMPLISH, "任务已完成");
		}
	}
}
