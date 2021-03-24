package com.tudi.yb.dao;

import com.tudi.yb.model.DbFormulaTreatments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DbFormulaTreatmentsRepository extends JpaRepository<DbFormulaTreatments, Integer>, JpaSpecificationExecutor<DbFormulaTreatments> {

}