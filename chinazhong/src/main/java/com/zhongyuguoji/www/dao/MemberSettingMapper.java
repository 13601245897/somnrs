package com.zhongyuguoji.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.entity.MemberSetting;

@Repository
@Transactional
public interface MemberSettingMapper extends JpaRepository<MemberSetting, Integer> {

}
