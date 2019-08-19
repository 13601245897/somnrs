package com.zhongyuguoji.www.results;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 * 
 * @author moese
 *
 */
public final class Constants {
	public static final Map<String, String> DESC = new HashMap<String, String>();
	public static final String COMMON_CODE = "200";
	public static final String FAILED_CODE = "300";

	private Constants() {
	}

	static {
		DESC.put(COMMON_CODE, "操作成功");
		DESC.put(FAILED_CODE, "操作失败");
	}
}
