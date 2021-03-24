package com.tudi.yb.dao;

import com.tudi.yb.model.TemplateMr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateMrRepository extends JpaRepository<TemplateMr, Integer>, JpaSpecificationExecutor<TemplateMr> {

}
