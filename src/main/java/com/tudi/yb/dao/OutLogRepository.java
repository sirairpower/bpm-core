package com.tudi.yb.dao;

import com.tudi.yb.model.OutLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutLogRepository extends JpaRepository<OutLog, Long>, JpaSpecificationExecutor<OutLog> {

}
