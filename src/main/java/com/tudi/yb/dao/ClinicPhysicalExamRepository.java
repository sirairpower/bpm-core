package com.tudi.yb.dao;

import com.tudi.yb.model.ClinicPhysicalExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClinicPhysicalExamRepository extends JpaRepository<ClinicPhysicalExam, Long>, JpaSpecificationExecutor<ClinicPhysicalExam> {

}
