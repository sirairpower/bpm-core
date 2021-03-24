package com.tudi.yb.dao;

import com.tudi.yb.model.PatientTreatmentMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientTreatmentMaterialRepository extends JpaRepository<PatientTreatmentMaterial, Long>, JpaSpecificationExecutor<PatientTreatmentMaterial> {

}
