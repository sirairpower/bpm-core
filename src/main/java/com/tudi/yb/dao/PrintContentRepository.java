package com.tudi.yb.dao;

import com.tudi.yb.model.PrintContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrintContentRepository extends JpaRepository<PrintContent, Void>, JpaSpecificationExecutor<PrintContent> {

}
