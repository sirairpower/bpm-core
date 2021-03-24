package com.tudi.yb.dao;

import com.tudi.yb.model.SimpleFormulaHerb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SimpleFormulaHerbRepository extends JpaRepository<SimpleFormulaHerb, String>, JpaSpecificationExecutor<SimpleFormulaHerb> {

}
