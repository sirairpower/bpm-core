package com.tudi.yb.dao;

import com.tudi.yb.model.SellItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SellItemRepository extends JpaRepository<SellItem, Long>, JpaSpecificationExecutor<SellItem> {

}
