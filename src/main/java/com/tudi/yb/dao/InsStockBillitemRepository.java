package com.tudi.yb.dao;

import com.tudi.yb.model.InsStockBillitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsStockBillitemRepository extends JpaRepository<InsStockBillitem, Integer>, JpaSpecificationExecutor<InsStockBillitem> {

}
