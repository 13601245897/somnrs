package com.zhongyuguoji.www.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.dao.IntegramlRuleMapper;
import com.zhongyuguoji.www.entity.IntegramlRule;
import com.zhongyuguoji.www.util.StringUtil;
@Transactional
@Service
public class IntegramlRuleService {
	@Resource
	private IntegramlRuleMapper ilm;

	public IntegramlRule getIntegramlRuleByMethodName(String methodName) {

		if (StringUtil.isNullOrEmpty(methodName)) {
			return null;
		}

		return ilm.getIntegramlRuleByMethodName(methodName);
	}

	public List<IntegramlRule> getAll() {
		return ilm.findAll();
	}

	public IntegramlRule getIntegramlRuleById(Integer id) {
		if (id != null) {
			return ilm.getOne(id);
		}
		return null;
	}

	public void saveEntity(IntegramlRule entity) {
		if (entity != null) {
			ilm.save(entity);
		}
	}

	public void delEntity(Integer id) {
		if (id != null) {
			ilm.deleteById(id);
		}

	}
}
