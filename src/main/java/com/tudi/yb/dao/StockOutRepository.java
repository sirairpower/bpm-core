package com.tudi.yb.dao;

import com.tudi.yb.model.StockOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockOutRepository extends JpaRepository<StockOut, Long>, JpaSpecificationExecutor<StockOut> {

}
