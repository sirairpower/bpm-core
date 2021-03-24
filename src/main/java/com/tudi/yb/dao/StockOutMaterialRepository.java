package com.tudi.yb.dao;

import com.tudi.yb.model.StockOutMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockOutMaterialRepository extends JpaRepository<StockOutMaterial, Long>, JpaSpecificationExecutor<StockOutMaterial> {

}
