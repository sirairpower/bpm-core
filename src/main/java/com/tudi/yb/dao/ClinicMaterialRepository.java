package com.tudi.yb.dao;

import com.tudi.yb.model.ClinicMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClinicMaterialRepository extends JpaRepository<ClinicMaterial, Integer>, JpaSpecificationExecutor<ClinicMaterial> {

}
