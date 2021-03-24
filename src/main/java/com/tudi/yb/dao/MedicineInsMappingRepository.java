package com.tudi.yb.dao;

import com.tudi.yb.model.MedicineInsMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedicineInsMappingRepository extends JpaRepository<MedicineInsMapping, Integer>, JpaSpecificationExecutor<MedicineInsMapping> {

}
