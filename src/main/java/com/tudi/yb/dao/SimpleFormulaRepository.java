package com.tudi.yb.dao;

import com.tudi.yb.model.SimpleFormula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SimpleFormulaRepository extends JpaRepository<SimpleFormula, Long>, JpaSpecificationExecutor<SimpleFormula> {

}
