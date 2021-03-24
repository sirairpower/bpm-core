package com.tudi.yb.dao;

import com.tudi.yb.model.TemplateMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateMedicineRepository extends JpaRepository<TemplateMedicine, Long>, JpaSpecificationExecutor<TemplateMedicine> {

}
