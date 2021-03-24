package com.tudi.yb.dao;

import com.tudi.yb.model.InsMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsMedicineRepository extends JpaRepository<InsMedicine, Integer>, JpaSpecificationExecutor<InsMedicine> {

}
