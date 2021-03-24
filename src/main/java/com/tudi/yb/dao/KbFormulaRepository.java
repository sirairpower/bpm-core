package com.tudi.yb.dao;

import com.tudi.yb.model.KbFormula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KbFormulaRepository extends JpaRepository<KbFormula, Integer>, JpaSpecificationExecutor<KbFormula> {

}
