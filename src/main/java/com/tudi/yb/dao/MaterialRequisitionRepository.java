package com.tudi.yb.dao;

import com.tudi.yb.model.MaterialRequisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MaterialRequisitionRepository extends JpaRepository<MaterialRequisition, Long>, JpaSpecificationExecutor<MaterialRequisition> {

}
