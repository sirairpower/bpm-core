package com.tudi.yb.dao;

import com.tudi.yb.model.VisitMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VisitMsgRepository extends JpaRepository<VisitMsg, Long>, JpaSpecificationExecutor<VisitMsg> {

}
