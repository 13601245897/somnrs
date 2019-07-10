package com.zhongyuguoji.www.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.entity.Members;
import com.zhongyuguoji.www.util.StringUtil;
@Transactional
@Component
public class MembersInitialize {
	// 会员
	@Resource
	private MembersService mbService;

	public Members initialize(Integer sid) {
		// 拼接members数据入库

		// 根据请求头中的pid获取用户信息
		Members members = mbService.getMembersBySid(sid);
		if (members == null) {
			return null;
		}
		if (members.getTotal() == null) {
			// 初始化赋值
			members.setTotal(0);
		}
		if (members.getTotalCount() == null) {
			// 初始化赋值
			members.setTotalCount(0);
		}
		if (members.getTotalCountNew() == null) {
			// 初始化赋值
			members.setTotalCountNew(0);
		}
		if (StringUtil.isNullOrEmpty(members.getGrade())) {
			members.setGrade("普通会员");
		}

		return members;
	}
}
