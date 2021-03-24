package com.tudi.yb.dao;

import com.tudi.yb.model.SimpleFormulaCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SimpleFormulaCategoryRepository extends JpaRepository<SimpleFormulaCategory, Long>, JpaSpecificationExecutor<SimpleFormulaCategory> {

}
