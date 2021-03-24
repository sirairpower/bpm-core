package com.tudi.yb.dao;

import com.tudi.yb.model.WxPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WxPatientRepository extends JpaRepository<WxPatient, String>, JpaSpecificationExecutor<WxPatient> {

}
