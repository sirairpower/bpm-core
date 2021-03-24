package com.tudi.yb.dao;

import com.tudi.yb.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>, JpaSpecificationExecutor<Diagnosis> {

}
