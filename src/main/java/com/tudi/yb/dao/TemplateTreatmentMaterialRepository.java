package com.tudi.yb.dao;

import com.tudi.yb.model.TemplateTreatmentMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateTreatmentMaterialRepository extends JpaRepository<TemplateTreatmentMaterial, Void>, JpaSpecificationExecutor<TemplateTreatmentMaterial> {

}
