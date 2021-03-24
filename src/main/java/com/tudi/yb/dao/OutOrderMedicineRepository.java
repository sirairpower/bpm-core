package com.tudi.yb.dao;

import com.tudi.yb.model.OutOrderMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutOrderMedicineRepository extends JpaRepository<OutOrderMedicine, Long>, JpaSpecificationExecutor<OutOrderMedicine> {

}
