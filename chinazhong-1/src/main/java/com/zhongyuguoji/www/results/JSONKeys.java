package com.zhongyuguoji.www.results;

/**
 * Response json 格式节点名称集合， 及对应放入MAP时的Key
 *
 * @author Moses
 */
public enum JSONKeys {
	CODE("code"), DESC("desc"), DATA("data");

	String key = null;

	JSONKeys(String key) {
		this.key = key;
	}

	public String getValue() {
		return key;
	}
}
