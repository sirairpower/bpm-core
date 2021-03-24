package com.tudi.yb.dao;

import com.tudi.yb.model.ListFormulaSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ListFormulaSourceRepository extends JpaRepository<ListFormulaSource, Integer>, JpaSpecificationExecutor<ListFormulaSource> {

}
