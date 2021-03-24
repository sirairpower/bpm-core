package com.tudi.yb.dao;

import com.tudi.yb.model.Priceitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PriceitemRepository extends JpaRepository<Priceitem, String>, JpaSpecificationExecutor<Priceitem> {

}
