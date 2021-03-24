package com.tudi.yb.dao;

import com.tudi.yb.model.OutOrderConfirmDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutOrderConfirmDetailRepository extends JpaRepository<OutOrderConfirmDetail, Long>, JpaSpecificationExecutor<OutOrderConfirmDetail> {

}
