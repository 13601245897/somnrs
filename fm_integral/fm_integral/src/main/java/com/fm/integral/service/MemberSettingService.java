package com.fm.integral.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.dao.MemberSettingMapper;
import com.fm.integral.entity.MemberSetting;

@Service
@Transactional
public class MemberSettingService {

	@Resource
	private MemberSettingMapper msm;

	public void insert(MemberSetting entity) {
		if (entity != null) {
			msm.save(entity);
		}
	}

	public MemberSetting getMemberSettingById(Integer id) {
		if (id != null) {
			return msm.getOne(id);
		}
		return null;
	}

	public void delMemberSettingById(Integer id) {
		if (id != null) {
			msm.deleteById(id);
		}
	}

	public List<MemberSetting> getAll() {
		return msm.findAll();
	}
}
