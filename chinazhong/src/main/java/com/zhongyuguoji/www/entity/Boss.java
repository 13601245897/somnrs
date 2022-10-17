package com.zhongyuguoji.www.entity;

public class Boss {
	private Mycallback myCallback;

	public void doCall() {
		myCallback.function();
	}

	public void setMyCallback(Mycallback myCallback) {
		this.myCallback = myCallback;
		myCallback.function();
	}
}
