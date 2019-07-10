package com.zhongyuguoji.www.util;

public enum JSONKeys {
	CODE("code"), DESC("desc"), DATA("data"), PAGE("page"), LIST("list");

	String key = null;

	private JSONKeys(String key) {
		this.key = key;
	}

	public String getValue() {
		return key;
	}
}
