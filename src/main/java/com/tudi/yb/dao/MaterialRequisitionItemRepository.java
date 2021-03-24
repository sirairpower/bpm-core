package com.tudi.yb.dao;

import com.tudi.yb.model.MaterialRequisitionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MaterialRequisitionItemRepository extends JpaRepository<MaterialRequisitionItem, Long>, JpaSpecificationExecutor<MaterialRequisitionItem> {

}
