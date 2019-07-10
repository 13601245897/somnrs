package com.fm.integral.service;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.dao.IntegramlRuleMapper;
import com.fm.integral.entity.IntegramlRule;
import com.fm.integral.util.StringUtil;

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

	public Page<IntegramlRule> getAll(Integer pageNumber, Integer pageSize, IntegramlRule integramlRule) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		PageRequest pageable = this.buildPageRequest(pageNumber, pageSize, sort);
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true).withIgnorePaths("focus");
		Example<IntegramlRule> example = Example.of(integramlRule, matcher);
		return ilm.findAll(example, pageable);
	}

	private PageRequest buildPageRequest(Integer pageNumber, Integer pageSize, Sort sort) {
		return PageRequest.of(pageNumber, pageSize, sort);
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

	public Integer getTaskByCirculation(Integer circulation) {
		if (circulation != null) {
			return ilm.getTaskByCirculation(circulation);
		}
		return null;
	}
}
