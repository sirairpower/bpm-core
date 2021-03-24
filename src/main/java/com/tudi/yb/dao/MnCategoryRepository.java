package com.tudi.yb.dao;

import com.tudi.yb.model.MnCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MnCategoryRepository extends JpaRepository<MnCategory, Long>, JpaSpecificationExecutor<MnCategory> {

}
