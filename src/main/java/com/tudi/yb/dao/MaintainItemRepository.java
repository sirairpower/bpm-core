package com.tudi.yb.dao;

import com.tudi.yb.model.MaintainItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MaintainItemRepository extends JpaRepository<MaintainItem, Long>, JpaSpecificationExecutor<MaintainItem> {

}
