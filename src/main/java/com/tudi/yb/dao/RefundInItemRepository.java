package com.tudi.yb.dao;

import com.tudi.yb.model.RefundInItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RefundInItemRepository extends JpaRepository<RefundInItem, Long>, JpaSpecificationExecutor<RefundInItem> {

}
