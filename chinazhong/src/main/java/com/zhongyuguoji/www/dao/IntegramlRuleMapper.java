package com.zhongyuguoji.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.entity.IntegramlRule;

@Repository
@Transactional
public interface IntegramlRuleMapper extends JpaRepository<IntegramlRule, Integer> {
	@Query("from IntegramlRule ir where ir.integramlUrl = ?1")
	IntegramlRule getIntegramlRuleByMethodName(String methodName);

}
