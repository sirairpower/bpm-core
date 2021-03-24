package com.tudi.yb.dao;

import com.tudi.yb.model.InsStockBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsStockBillRepository extends JpaRepository<InsStockBill, Long>, JpaSpecificationExecutor<InsStockBill> {

}
