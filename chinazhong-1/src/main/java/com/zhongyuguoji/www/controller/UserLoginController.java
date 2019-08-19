package com.zhongyuguoji.www.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhongyuguoji.www.entity.WxUser;
import com.zhongyuguoji.www.results.Constants;
import com.zhongyuguoji.www.results.ResponseUtils;
import com.zhongyuguoji.www.service.WxUserService;
import com.zhongyuguoji.www.utils.Base64Utils;
import com.zhongyuguoji.www.utils.HttpClientUtil;
import com.zhongyuguoji.www.utils.WechatGetUserInfoUtil;

@RestController
@RequestMapping("/wechat")
public class UserLoginController {
	@Resource
	private WxUserService wxUserService;

	@PostMapping("/userinfo")
	public void login(String encryptedData, String iv, String code, HttpServletResponse response) {
		WxUser wxUser = new WxUser();
		if (StringUtils.isNotBlank(code)) {
			String appid = "wxe4bf451bcfe09a67";
			String appSecret = "f69b595c1dce135c2ea0fae30f38d019";
			String apiUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appSecret
					+ "&js_code=" + code + "&grant_type=authorization_code";
			String responseBody = HttpClientUtil.doGet(apiUrl);
			JSONObject jsonObject = JSON.parseObject(responseBody);
			if (StringUtils.isNotBlank(jsonObject.getString("openid"))
					&& StringUtils.isNotBlank(jsonObject.getString("session_key"))) {
				JSONObject userInfoJSON = WechatGetUserInfoUtil.getUserInfo(encryptedData,
						jsonObject.getString("session_key"), iv);
				if (userInfoJSON != null) {
					wxUser.setId(userInfoJSON.getString("openid"));
					wxUser.setCreateTime(new Date());
					wxUser.setHeadImage(userInfoJSON.getString("avatarUrl"));
					wxUser.setNickName(Base64Utils.encode((userInfoJSON.getString("nickName").getBytes())));
					wxUser.setOpenId(userInfoJSON.getString("openId"));
					wxUser.setPopStatus("1");
					wxUser.setSid("sid");
					wxUser.setSkey("skey");
					wxUser.setUpdateTime(new Date());
					wxUser.setUpdateUserInfoTime(new Date());
				}
				WxUser user = wxUserService.selectByPrimaryKey(wxUser.getId());
				if (user == null) {
					wxUserService.insertUser(wxUser);
				}
				ResponseUtils.responseAsJson(Constants.COMMON_CODE, Constants.DESC.get(Constants.COMMON_CODE), wxUser,
						response);
			}
		}
		ResponseUtils.responseAsJson(Constants.FAILED_CODE, Constants.DESC.get(Constants.FAILED_CODE), response);
	}
}
