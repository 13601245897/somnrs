package com.zhongyuguoji.www.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhongyuguoji.www.entity.Integraml;

@Repository
@Transactional
public interface IntegramlMapper extends JpaRepository<Integraml, Integer> {
	@Query(value = "from Integraml i where i.name=?1")
	Integraml getIntegramlRuleByMethodName(String name);
	
//	@Query(value = "sum(count_day + count_new) from Integraml where m_id = ?1")
//	Integer getCountIntegramByMId(Integer mId);

}
