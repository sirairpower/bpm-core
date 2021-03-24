package com.tudi.yb.dao;

import com.tudi.yb.model.OutOrderDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutOrderDiagnosisRepository extends JpaRepository<OutOrderDiagnosis, Integer>, JpaSpecificationExecutor<OutOrderDiagnosis> {

}
