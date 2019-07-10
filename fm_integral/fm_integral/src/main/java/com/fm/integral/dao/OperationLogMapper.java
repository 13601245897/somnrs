package com.fm.integral.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fm.integral.entity.OperationLog;

@Transactional
@Repository
public interface OperationLogMapper extends JpaRepository<OperationLog, Integer> {


}
