package com.tudi.yb.dao;

import com.tudi.yb.model.BillPriceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BillPriceItemRepository extends JpaRepository<BillPriceItem, Long>, JpaSpecificationExecutor<BillPriceItem> {

}
