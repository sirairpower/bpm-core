package com.bpm.dao;

import com.bpm.model.ShopeeProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShopeeProductInfoRepository extends JpaRepository<ShopeeProductInfo, String>, JpaSpecificationExecutor<ShopeeProductInfo> {

}
