package com.tudi.yb.dao;

import com.tudi.yb.model.TemplateHerb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateHerbRepository extends JpaRepository<TemplateHerb, Long>, JpaSpecificationExecutor<TemplateHerb> {

}
