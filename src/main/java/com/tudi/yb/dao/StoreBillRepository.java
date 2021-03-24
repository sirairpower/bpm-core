package com.tudi.yb.dao;

import com.tudi.yb.model.StoreBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreBillRepository extends JpaRepository<StoreBill, Long>, JpaSpecificationExecutor<StoreBill> {

}
