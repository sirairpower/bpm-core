package com.tudi.yb.dao;

import com.tudi.yb.model.StockInMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StockInMedicineRepository extends JpaRepository<StockInMedicine, Long>, JpaSpecificationExecutor<StockInMedicine> {

}
