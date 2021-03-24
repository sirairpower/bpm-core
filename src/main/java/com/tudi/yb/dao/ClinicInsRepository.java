package com.tudi.yb.dao;

import com.tudi.yb.model.ClinicIns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClinicInsRepository extends JpaRepository<ClinicIns, Integer>, JpaSpecificationExecutor<ClinicIns> {

}
