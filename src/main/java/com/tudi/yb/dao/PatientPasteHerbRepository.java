package com.tudi.yb.dao;

import com.tudi.yb.model.PatientPasteHerb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatientPasteHerbRepository extends JpaRepository<PatientPasteHerb, Long>, JpaSpecificationExecutor<PatientPasteHerb> {

}
