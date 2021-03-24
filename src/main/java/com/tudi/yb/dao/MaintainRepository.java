package com.tudi.yb.dao;

import com.tudi.yb.model.Maintain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MaintainRepository extends JpaRepository<Maintain, Long>, JpaSpecificationExecutor<Maintain> {

}
