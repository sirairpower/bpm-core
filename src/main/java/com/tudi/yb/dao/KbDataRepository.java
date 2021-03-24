package com.tudi.yb.dao;

import com.tudi.yb.model.KbData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KbDataRepository extends JpaRepository<KbData, Integer>, JpaSpecificationExecutor<KbData> {

}
