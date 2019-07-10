package com.fm.integral.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.entity.MemberSetting;

@Repository
@Transactional
public interface MemberSettingMapper extends JpaRepository<MemberSetting, Integer> {

}
