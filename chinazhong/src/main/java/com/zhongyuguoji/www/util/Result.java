package com.zhongyuguoji.www.util;

public class Result {

	/**
	 * 返回码
	 */
	private String CODE;
	/**
	 * 返回信息
	 */
	private String DESC;
	/**
	 * 返回数据
	 */
	private Object data;

	public Result() {
		super();
	}

	public Result(String CODE, String DESC) {
		this.CODE = CODE;
		this.DESC = DESC;
	}

	public Result(String CODE, String DESC, Object data) {
		this.CODE = CODE;
		this.DESC = DESC;
		this.data = data;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getDESC() {
		return DESC;
	}

	public void setDESC(String dESC) {
		DESC = dESC;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
