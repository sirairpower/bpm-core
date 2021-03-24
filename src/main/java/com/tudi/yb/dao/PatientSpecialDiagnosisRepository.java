package com.tudi.yb.dao;

import com.tudi.yb.model.PatientSpecialDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientSpecialDiagnosisRepository extends JpaRepository<PatientSpecialDiagnosis, Long>, JpaSpecificationExecutor<PatientSpecialDiagnosis> {

}
