package com.tudi.yb.dao;

import com.tudi.yb.model.KbCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KbCategoryRepository extends JpaRepository<KbCategory, Integer>, JpaSpecificationExecutor<KbCategory> {

}
