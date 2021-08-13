package com.bpm.dao;

import com.bpm.model.ShopeeVariantProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShopeeVariantProdRepository extends JpaRepository<ShopeeVariantProd, String>, JpaSpecificationExecutor<ShopeeVariantProd> {

}
