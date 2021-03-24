package com.tudi.yb.dao;

import com.tudi.yb.model.WxpayTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WxpayTransactionRepository extends JpaRepository<WxpayTransaction, Long>, JpaSpecificationExecutor<WxpayTransaction> {

}
