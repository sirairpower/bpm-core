package com.tudi.yb.dao;

import com.tudi.yb.model.StockIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockInRepository extends JpaRepository<StockIn, Long>, JpaSpecificationExecutor<StockIn> {

}
