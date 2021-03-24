package com.tudi.yb.dao;

import com.tudi.yb.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SellRepository extends JpaRepository<Sell, Long>, JpaSpecificationExecutor<Sell> {

}
