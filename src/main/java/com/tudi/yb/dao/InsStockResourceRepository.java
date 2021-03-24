package com.tudi.yb.dao;

import com.tudi.yb.model.InsStockResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsStockResourceRepository extends JpaRepository<InsStockResource, Long>, JpaSpecificationExecutor<InsStockResource> {

}