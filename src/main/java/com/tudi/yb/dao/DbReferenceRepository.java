package com.tudi.yb.dao;

import com.tudi.yb.model.DbReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DbReferenceRepository extends JpaRepository<DbReference, Integer>, JpaSpecificationExecutor<DbReference> {

}
