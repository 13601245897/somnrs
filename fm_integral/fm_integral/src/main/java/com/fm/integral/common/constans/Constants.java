package com.fm.integral.common.constans;

/**
 * @author moese
 */
import java.util.HashMap;
import java.util.Map;

public final class Constants {
	/**
	 * 成功状态码
	 * 
	 * @author moese
	 *
	 */
	public final static class Success {
		public final static String COMMON_CODE = "200";
		public final static String ACCOMPLISH = "201";
		public final static Map<String, String> SUCCESS = new HashMap<String, String>();
		static {
			SUCCESS.put(COMMON_CODE, "操作成功");
			SUCCESS.put(ACCOMPLISH, "任务已完成");
		}
	}

	/**
	 * 失败状态吗
	 * 
	 * @author moese
	 *
	 */
	public final static class Failed {
		public final static String MISS_CODE = "400";

		public final static Map<String, String> FAILED = new HashMap<String, String>();
		static {
			FAILED.put(MISS_CODE, "操作失败");
		}
	}

}
