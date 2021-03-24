package com.tudi.yb.dao;

import com.tudi.yb.model.PatientFormula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientFormulaRepository extends JpaRepository<PatientFormula, Long>, JpaSpecificationExecutor<PatientFormula> {

}
