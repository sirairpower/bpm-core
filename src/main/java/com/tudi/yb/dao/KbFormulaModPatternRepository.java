package com.tudi.yb.dao;

import com.tudi.yb.model.KbFormulaModPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KbFormulaModPatternRepository extends JpaRepository<KbFormulaModPattern, Long>, JpaSpecificationExecutor<KbFormulaModPattern> {

}
