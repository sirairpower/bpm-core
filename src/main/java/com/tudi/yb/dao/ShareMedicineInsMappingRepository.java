package com.tudi.yb.dao;

import com.tudi.yb.model.ShareMedicineInsMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShareMedicineInsMappingRepository extends JpaRepository<ShareMedicineInsMapping, Void>, JpaSpecificationExecutor<ShareMedicineInsMapping> {

}
