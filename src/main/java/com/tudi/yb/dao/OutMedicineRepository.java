package com.tudi.yb.dao;

import com.tudi.yb.model.OutMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutMedicineRepository extends JpaRepository<OutMedicine, Long>, JpaSpecificationExecutor<OutMedicine> {

}
