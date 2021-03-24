package com.tudi.yb.dao;

import com.tudi.yb.model.CountingMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountingMedicineRepository extends JpaRepository<CountingMedicine, Long>, JpaSpecificationExecutor<CountingMedicine> {

}
