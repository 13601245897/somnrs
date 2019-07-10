package com.fm.integral.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.entity.MemberSetting;
@Transactional
@Component
public class MemberLevel {
	@Resource
	private MemberSettingService mss;

	public String getNameForTotle(Integer total) {
		if (total != null) {
			List<MemberSetting> all = mss.getAll();
			for (MemberSetting memberSetting : all) {
				if (total >= memberSetting.getFloorLevel() && total <= memberSetting.getUpperLevel()) {
					return memberSetting.getName();
				}
			}
		}
		return null;
	}
}
