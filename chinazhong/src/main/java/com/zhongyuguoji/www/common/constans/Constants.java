package com.zhongyuguoji.www.common.constans;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

	public final static class MyException {
		public final static String COMMON_CODE = "1";
		public final static String accomplish = "1";
		public final static Map<String, String> DESC = new HashMap<String, String>();

		static {
			DESC.put(COMMON_CODE, "操作失败");

		}
	}

	public final static class Success {
		public final static String COMMON_CODE = "200";
		public final static String ACCOMPLISH = "201";
		public final static Map<String, String> SUCCESS = new HashMap<String, String>();
		static {
			SUCCESS.put(COMMON_CODE, "操作成功");
			SUCCESS.put(ACCOMPLISH, "任务已完成");
		}
	}

	// public final static Exception throwException(String code) {
	//
	// if (StringUtils.isEmpty(code))
	// return new Exception(Constants.Exception.COMMON_CODE,
	// Constants.Exception.DESC
	// .get(Constants.Exception.COMMON_CODE));
	//
	// return new Exception(code, Constants.Exception.DESC.get(code));
	// }
}
