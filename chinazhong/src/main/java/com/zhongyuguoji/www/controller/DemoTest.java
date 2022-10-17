package com.zhongyuguoji.www.controller;

import com.zhongyuguoji.www.entity.Boss;
import com.zhongyuguoji.www.entity.Mycallback;
import com.zhongyuguoji.www.util.SendPost;

public class DemoTest {
	
//	public static void main(String[] args) {
//		String url = "";
//		String param = "";
//		String sendPost = SendPost.sendPost(url, param);
//		
//	}
	
	public static void main(String[] args) {
		Boss boss = new Boss();
		boss.setMyCallback(new Mycallback() {
			
			@Override
			public void function() {
				System.out.println("这个是接口");
			}
		});
		boss.doCall();
	}
}
