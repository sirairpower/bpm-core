package com.tudi.yb.dao;

import com.tudi.yb.model.TemplateTreatmentMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TemplateTreatmentMedicineRepository extends JpaRepository<TemplateTreatmentMedicine, Long>, JpaSpecificationExecutor<TemplateTreatmentMedicine> {

}
