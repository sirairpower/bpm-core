package com.tudi.yb.dao;

import com.tudi.yb.model.ShareMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShareMedicineRepository extends JpaRepository<ShareMedicine, Long>, JpaSpecificationExecutor<ShareMedicine> {

}
