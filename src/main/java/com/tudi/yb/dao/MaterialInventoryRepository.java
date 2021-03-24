package com.tudi.yb.dao;

import com.tudi.yb.model.MaterialInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MaterialInventoryRepository extends JpaRepository<MaterialInventory, Long>, JpaSpecificationExecutor<MaterialInventory> {

}
