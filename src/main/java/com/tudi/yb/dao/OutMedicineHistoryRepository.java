package com.tudi.yb.dao;

import com.tudi.yb.model.OutMedicineHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutMedicineHistoryRepository extends JpaRepository<OutMedicineHistory, Long>, JpaSpecificationExecutor<OutMedicineHistory> {

}