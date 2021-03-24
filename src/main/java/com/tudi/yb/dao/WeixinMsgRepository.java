package com.tudi.yb.dao;

import com.tudi.yb.model.WeixinMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WeixinMsgRepository extends JpaRepository<WeixinMsg, Long>, JpaSpecificationExecutor<WeixinMsg> {

}
