package com.fm.integral.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.entity.IntegramlRule;

@Repository
@Transactional
public interface IntegramlRuleMapper extends JpaRepository<IntegramlRule, Integer> {
	@Query("from IntegramlRule ir where ir.integramlUrl = ?1")
	IntegramlRule getIntegramlRuleByMethodName(String methodName);

	@Query(value = "select sum(itg.restrictive) from IntegramlRule itg where itg.circulation = ?1")
	Integer getTaskByCirculation(Integer circulation);

}
