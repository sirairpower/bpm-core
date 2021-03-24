package com.tudi.yb.dao;

import com.tudi.yb.model.OutService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutServiceRepository extends JpaRepository<OutService, Long>, JpaSpecificationExecutor<OutService> {

}
