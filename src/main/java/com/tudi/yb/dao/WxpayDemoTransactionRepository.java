package com.tudi.yb.dao;

import com.tudi.yb.model.WxpayDemoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WxpayDemoTransactionRepository extends JpaRepository<WxpayDemoTransaction, Long>, JpaSpecificationExecutor<WxpayDemoTransaction> {

}
