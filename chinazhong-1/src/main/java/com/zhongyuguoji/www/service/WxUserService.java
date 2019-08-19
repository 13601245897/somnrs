package com.zhongyuguoji.www.service;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.zhongyuguoji.www.entity.WxUser;
import com.zhongyuguoji.www.mapper.WxUserMapper;

@Service
public class WxUserService {
	@Resource
	private WxUserMapper wxUserMapper;

	public WxUser selectByPrimaryKey(String id) {
		if (StringUtils.isNotEmpty(id)) {
			return wxUserMapper.selectByPrimaryKey(id);
		}
		return null;
	}

	public int insertUser(WxUser user) {
		return wxUserMapper.insert(user);

	}
}
