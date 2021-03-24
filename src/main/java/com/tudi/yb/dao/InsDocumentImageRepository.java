package com.tudi.yb.dao;

import com.tudi.yb.model.InsDocumentImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsDocumentImageRepository extends JpaRepository<InsDocumentImage, Long>, JpaSpecificationExecutor<InsDocumentImage> {

}
