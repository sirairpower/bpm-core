package com.tudi.yb.dao;

import com.tudi.yb.model.TemplateCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateCategoryRepository extends JpaRepository<TemplateCategory, Long>, JpaSpecificationExecutor<TemplateCategory> {

}
