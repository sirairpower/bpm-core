package com.tudi.yb.dao;

import com.tudi.yb.model.HisBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HisBillRepository extends JpaRepository<HisBill, Long>, JpaSpecificationExecutor<HisBill> {

}
