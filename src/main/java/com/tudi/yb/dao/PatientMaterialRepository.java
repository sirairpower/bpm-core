package com.tudi.yb.dao;

import com.tudi.yb.model.PatientMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientMaterialRepository extends JpaRepository<PatientMaterial, Long>, JpaSpecificationExecutor<PatientMaterial> {

}
