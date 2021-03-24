package com.tudi.yb.dao;

import com.tudi.yb.model.OutOrderHerb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutOrderHerbRepository extends JpaRepository<OutOrderHerb, Long>, JpaSpecificationExecutor<OutOrderHerb> {

}
