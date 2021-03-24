package com.tudi.yb.dao;

import com.tudi.yb.model.MnExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MnExamRepository extends JpaRepository<MnExam, Long>, JpaSpecificationExecutor<MnExam> {

}
