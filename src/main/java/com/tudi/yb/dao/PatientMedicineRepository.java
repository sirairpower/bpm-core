package com.tudi.yb.dao;

import com.tudi.yb.model.PatientMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientMedicineRepository extends JpaRepository<PatientMedicine, Long>, JpaSpecificationExecutor<PatientMedicine> {

}
