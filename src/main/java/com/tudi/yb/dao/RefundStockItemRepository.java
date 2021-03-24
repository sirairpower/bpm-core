package com.tudi.yb.dao;

import com.tudi.yb.model.RefundStockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RefundStockItemRepository extends JpaRepository<RefundStockItem, Long>, JpaSpecificationExecutor<RefundStockItem> {

}
