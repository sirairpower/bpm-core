package com.tudi.yb.dao;

import com.tudi.yb.model.OperatorSerialHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OperatorSerialHistoryRepository extends JpaRepository<OperatorSerialHistory, Long>, JpaSpecificationExecutor<OperatorSerialHistory> {

}
