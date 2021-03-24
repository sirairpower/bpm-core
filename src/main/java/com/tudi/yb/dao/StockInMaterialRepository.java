package com.tudi.yb.dao;

import com.tudi.yb.model.StockInMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockInMaterialRepository extends JpaRepository<StockInMaterial, Long>, JpaSpecificationExecutor<StockInMaterial> {

}
