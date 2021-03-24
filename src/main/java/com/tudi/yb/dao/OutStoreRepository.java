package com.tudi.yb.dao;

import com.tudi.yb.model.OutStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutStoreRepository extends JpaRepository<OutStore, Long>, JpaSpecificationExecutor<OutStore> {

}
