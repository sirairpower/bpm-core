package com.tudi.yb.dao;

import com.tudi.yb.model.StockOutMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockOutMedicineRepository extends JpaRepository<StockOutMedicine, Long>, JpaSpecificationExecutor<StockOutMedicine> {

}
