package com.tudi.yb.dao;

import com.tudi.yb.model.PatientTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientTreatmentRepository extends JpaRepository<PatientTreatment, Long>, JpaSpecificationExecutor<PatientTreatment> {

}
