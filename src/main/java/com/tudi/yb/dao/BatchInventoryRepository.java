package com.tudi.yb.dao;

import com.tudi.yb.model.BatchInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BatchInventoryRepository extends JpaRepository<BatchInventory, Long>, JpaSpecificationExecutor<BatchInventory> {

}
