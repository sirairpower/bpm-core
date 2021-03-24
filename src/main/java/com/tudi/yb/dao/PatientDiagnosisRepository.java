package com.tudi.yb.dao;

import com.tudi.yb.model.PatientDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientDiagnosisRepository extends JpaRepository<PatientDiagnosis, Long>, JpaSpecificationExecutor<PatientDiagnosis> {

}
