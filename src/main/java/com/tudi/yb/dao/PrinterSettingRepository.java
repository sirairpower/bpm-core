package com.tudi.yb.dao;

import com.tudi.yb.model.PrinterSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrinterSettingRepository extends JpaRepository<PrinterSetting, Integer>, JpaSpecificationExecutor<PrinterSetting> {

}
