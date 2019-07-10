package com.zhongyuguoji.www.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.dao.OperationLogMapper;
import com.zhongyuguoji.www.entity.OperationLog;

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

	public List<OperationLog> getAll() {
		return olp.findAll();
	}
}
