package com.tudi.yb.dao;

import com.tudi.yb.model.PatientMnExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientMnExamRepository extends JpaRepository<PatientMnExam, Long>, JpaSpecificationExecutor<PatientMnExam> {

}
