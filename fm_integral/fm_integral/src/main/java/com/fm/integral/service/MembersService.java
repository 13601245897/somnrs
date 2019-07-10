package com.fm.integral.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.dao.MembersMapper;
import com.fm.integral.entity.Members;
@Transactional
@Service
public class MembersService {
	@Resource
	private MembersMapper mm;

	public List<Members> getAll() {
		return mm.findAll();
	}

	public void saveMembers(Members entity) {
		if (entity != null) {
			mm.save(entity);
		}
	}

	public Members getMembersBySid(Integer id) {
		if (id == null) {
			return null;
		}
		return mm.getOne(id);
	}

	public void updateTimer(Integer totalCount) {
		if (totalCount != null) {
			mm.updateTimer(totalCount);
		}

	}

}
