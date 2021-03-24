package com.tudi.yb.dao;

import com.tudi.yb.model.WxMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WxMessageRepository extends JpaRepository<WxMessage, Long>, JpaSpecificationExecutor<WxMessage> {

}
