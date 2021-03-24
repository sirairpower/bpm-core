package com.tudi.yb.dao;

import com.tudi.yb.model.ReportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReportGroupRepository extends JpaRepository<ReportGroup, Long>, JpaSpecificationExecutor<ReportGroup> {

}
