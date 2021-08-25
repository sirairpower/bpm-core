package com.bpm.dao;

import com.bpm.model.ShopeeProductInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ShopeeProductInfoRepository extends JpaRepository<ShopeeProductInfo, Integer>, JpaSpecificationExecutor<ShopeeProductInfo> {

  @Query("select distinct prodInfo from ShopeeProductInfo prodInfo left join fetch prodInfo.shopeeVariantProds order by prodInfo.id asc")
  List<ShopeeProductInfo> fetchAllWithVariantion();

}
