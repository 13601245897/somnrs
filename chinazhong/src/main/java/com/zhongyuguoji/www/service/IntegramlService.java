package com.zhongyuguoji.www.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.dao.IntegramlMapper;
import com.zhongyuguoji.www.entity.Integraml;
import com.zhongyuguoji.www.util.StringUtil;

@Service
@Transactional
public class IntegramlService {
	@Resource
	private IntegramlMapper inm;

	public Integraml getIntegramlByName(String name) {
		if (StringUtil.isNullOrEmpty(name)) {
			return null;

		}
		return inm.getIntegramlRuleByMethodName(name);
	}

	public void updateIntegraml(Integraml entity) {
		if (entity != null) {
			inm.save(entity);
		}
	}
//	public Integer getCountIntegramByMId(Integer mId){
//		if(mId != null) {
//			return inm.getCountIntegramByMId(mId);
//		}
//		return null;
//	}
}
