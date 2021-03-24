package com.tudi.yb.dao;

import com.tudi.yb.model.PatientFormulaHerb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientFormulaHerbRepository extends JpaRepository<PatientFormulaHerb, Long>, JpaSpecificationExecutor<PatientFormulaHerb> {

}
