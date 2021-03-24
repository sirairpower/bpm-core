package com.tudi.yb.dao;

import com.tudi.yb.model.TreatmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TreatmentCategoryRepository extends JpaRepository<TreatmentCategory, Long>, JpaSpecificationExecutor<TreatmentCategory> {

}
