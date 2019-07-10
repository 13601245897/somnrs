package com.fm.integral.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.entity.Integraml;

@Repository
@Transactional
public interface IntegramlMapper extends JpaRepository<Integraml, Integer> {
	@Query(value = "from Integraml i where i.name=?1 and i.mId=?2")
	Integraml getIntegramlRuleByMethodName(String name, Integer mid);

	@Query(value = "select sum(il.countTask) from Integraml il where mId = ?1 and circulation=?2")
	Integer getCountTaskByMid(Integer mid, Integer circulation);

	@Query(value = "from Integraml where mId = ?1")
	List<Integraml> getIntegramlsByid(Integer mid);
}
