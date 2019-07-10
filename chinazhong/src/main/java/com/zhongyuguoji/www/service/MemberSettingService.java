package com.zhongyuguoji.www.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.dao.MemberSettingMapper;
import com.zhongyuguoji.www.entity.MemberSetting;

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
