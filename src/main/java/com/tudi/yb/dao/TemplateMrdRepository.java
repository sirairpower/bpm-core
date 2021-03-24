package com.tudi.yb.dao;

import com.tudi.yb.model.TemplateMrd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateMrdRepository extends JpaRepository<TemplateMrd, Integer>, JpaSpecificationExecutor<TemplateMrd> {

}
