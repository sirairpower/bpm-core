package com.tudi.yb.dao;

import com.tudi.yb.model.PhysicalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhysicalExamRepository extends JpaRepository<PhysicalExam, Long>, JpaSpecificationExecutor<PhysicalExam> {

}
