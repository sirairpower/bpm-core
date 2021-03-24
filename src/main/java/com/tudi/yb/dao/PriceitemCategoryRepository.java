package com.tudi.yb.dao;

import com.tudi.yb.model.PriceitemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PriceitemCategoryRepository extends JpaRepository<PriceitemCategory, String>, JpaSpecificationExecutor<PriceitemCategory> {

}
