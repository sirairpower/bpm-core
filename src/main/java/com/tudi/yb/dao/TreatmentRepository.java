package com.tudi.yb.dao;

import com.tudi.yb.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TreatmentRepository extends JpaRepository<Treatment, Long>, JpaSpecificationExecutor<Treatment> {

}
