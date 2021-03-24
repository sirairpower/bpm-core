package com.tudi.yb.dao;

import com.tudi.yb.model.KbFormulaModHerb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KbFormulaModHerbRepository extends JpaRepository<KbFormulaModHerb, Long>, JpaSpecificationExecutor<KbFormulaModHerb> {

}
