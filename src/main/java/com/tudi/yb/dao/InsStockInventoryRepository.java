package com.tudi.yb.dao;

import com.tudi.yb.model.InsStockInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsStockInventoryRepository extends JpaRepository<InsStockInventory, Long>, JpaSpecificationExecutor<InsStockInventory> {

}
