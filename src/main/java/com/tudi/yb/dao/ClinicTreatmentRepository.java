package com.tudi.yb.dao;

import com.tudi.yb.model.ClinicTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClinicTreatmentRepository extends JpaRepository<ClinicTreatment, Long>, JpaSpecificationExecutor<ClinicTreatment> {

}
