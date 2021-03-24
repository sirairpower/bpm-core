package com.tudi.yb.dao;

import com.tudi.yb.model.DbWdDiagnoses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DbWdDiagnosesRepository extends JpaRepository<DbWdDiagnoses, Void>, JpaSpecificationExecutor<DbWdDiagnoses> {

}