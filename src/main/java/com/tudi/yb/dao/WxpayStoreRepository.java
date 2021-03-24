package com.tudi.yb.dao;

import com.tudi.yb.model.WxpayStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WxpayStoreRepository extends JpaRepository<WxpayStore, Long>, JpaSpecificationExecutor<WxpayStore> {

}
