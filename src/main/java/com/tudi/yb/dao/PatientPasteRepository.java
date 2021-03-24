package com.tudi.yb.dao;

import com.tudi.yb.model.PatientPaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientPasteRepository extends JpaRepository<PatientPaste, Long>, JpaSpecificationExecutor<PatientPaste> {

}
