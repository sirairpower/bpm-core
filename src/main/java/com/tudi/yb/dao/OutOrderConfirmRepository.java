package com.tudi.yb.dao;

import com.tudi.yb.model.OutOrderConfirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutOrderConfirmRepository extends JpaRepository<OutOrderConfirm, Long>, JpaSpecificationExecutor<OutOrderConfirm> {

}
