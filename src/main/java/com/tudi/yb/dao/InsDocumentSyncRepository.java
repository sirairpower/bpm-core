package com.tudi.yb.dao;

import com.tudi.yb.model.InsDocumentSync;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsDocumentSyncRepository extends JpaRepository<InsDocumentSync, Long>, JpaSpecificationExecutor<InsDocumentSync> {

}
