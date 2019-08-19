package com.zhongyuguoji.www.mapper;

import org.springframework.stereotype.Component;

import com.zhongyuguoji.www.entity.WxUser;
public interface WxUserMapper {

	WxUser selectByPrimaryKey(String id);

	int insert(WxUser user);

}
