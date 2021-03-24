package com.tudi.yb.dao;

import com.tudi.yb.model.TudiAppLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TudiAppLogRepository extends JpaRepository<TudiAppLog, Long>, JpaSpecificationExecutor<TudiAppLog> {

}
