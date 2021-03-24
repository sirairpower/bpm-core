package com.tudi.yb.dao;

import com.tudi.yb.model.InsSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsSupplierRepository extends JpaRepository<InsSupplier, Long>, JpaSpecificationExecutor<InsSupplier> {

}
