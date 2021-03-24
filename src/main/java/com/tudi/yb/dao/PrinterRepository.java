package com.tudi.yb.dao;

import com.tudi.yb.model.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrinterRepository extends JpaRepository<Printer, Integer>, JpaSpecificationExecutor<Printer> {

}
