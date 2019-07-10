package com.fm.integral.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.dao.IntegramlMapper;
import com.fm.integral.entity.Integraml;
import com.fm.integral.util.StringUtil;

@Service
@Transactional
public class IntegramlService {
	@Resource
	private IntegramlMapper inm;

	public Page<Integraml> getAll(Integer pageNumber, Integer pageSize, Integraml integraml) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		PageRequest pageable = this.buildPageRequset(pageNumber, pageSize, sort);
		//模糊查询
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true).withIgnorePaths("focus");
		Example<Integraml> example = Example.of(integraml, matcher);
		return inm.findAll(example, pageable);
	}

	private PageRequest buildPageRequset(Integer pageNumber, Integer pageSize, Sort sort) {
		return PageRequest.of(pageNumber, pageSize, sort);
	}

	public Integraml getIntegramlByName(String name, Integer mid) {
		if (StringUtil.isNullOrEmpty(name)) {
			return null;

		}
		return inm.getIntegramlRuleByMethodName(name, mid);
	}

	public List<Integraml> getIntegramlsByid(Integer mid) {
		if (mid != null) {
			return inm.getIntegramlsByid(mid);
		}
		return null;
	}

	public void updateIntegraml(Integraml entity) {
		if (entity != null) {
			inm.save(entity);
		}
	}

	public Integer getCountTaskByMid(Integer mid, Integer circulation) {
		if (mid != null) {
			return inm.getCountTaskByMid(mid, circulation);
		}
		return null;
	}

}
