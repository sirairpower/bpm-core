package com.tudi.yb.dao;

import com.tudi.yb.model.PatientPhysicalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientPhysicalExamRepository extends JpaRepository<PatientPhysicalExam, Long>, JpaSpecificationExecutor<PatientPhysicalExam> {

}
