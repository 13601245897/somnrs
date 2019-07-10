package com.fm.integral.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.integral.common.constans.Constants;
import com.fm.integral.service.WechatService;
import com.fm.integral.util.ResponseUtils;

@RequestMapping("/wechat")
@RestController
public class WechatController {
	@Resource
	private WechatService ws;

	@GetMapping("/getWechatList")
	public void getWechatList(Integer uxid, HttpServletResponse response) {
		if (uxid != null) {
			HashMap<String, Object> wechatList = ws.getWechatList(uxid);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), wechatList, response);
		}
	}
}
