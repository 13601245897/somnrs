package com.zhongyuguoji.www.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.dao.MembersMapper;
import com.zhongyuguoji.www.entity.Members;
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

	public void updateTimer(Long totalCount, Long totalNew) {
		if (totalCount != null && totalNew != null) {
			mm.updateTimer(totalCount, totalNew);
		}

	}

}
