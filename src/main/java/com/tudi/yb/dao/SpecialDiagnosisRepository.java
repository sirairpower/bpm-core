package com.tudi.yb.dao;

import com.tudi.yb.model.SpecialDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecialDiagnosisRepository extends JpaRepository<SpecialDiagnosis, Long>, JpaSpecificationExecutor<SpecialDiagnosis> {

}
