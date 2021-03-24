package com.tudi.yb.dao;

import com.tudi.yb.model.RecordKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecordKeywordRepository extends JpaRepository<RecordKeyword, String>, JpaSpecificationExecutor<RecordKeyword> {

}
