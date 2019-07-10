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

import com.fm.integral.dao.OperationLogMapper;
import com.fm.integral.entity.OperationLog;

@Transactional
@Service
public class OperationLogService {
	@Resource
	private OperationLogMapper olp;

	public void saveLog(OperationLog entity) {
		if (entity != null) {
			olp.save(entity);
		}
	}

	public Page<OperationLog> getAll(Integer pageNumber, Integer pageSize, OperationLog operationLog) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		PageRequest pageable = this.buildPageRequest(pageNumber, pageSize, sort);
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true).withIgnorePaths("focus");
		Example<OperationLog> example = Example.of(operationLog, matcher);
		return olp.findAll(example, pageable);
	}

	private PageRequest buildPageRequest(Integer pageNumber, Integer pageSize, Sort sort) {
		return PageRequest.of(pageNumber, pageSize, sort);
	}
}
