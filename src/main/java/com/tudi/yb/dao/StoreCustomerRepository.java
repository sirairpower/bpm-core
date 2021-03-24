package com.tudi.yb.dao;

import com.tudi.yb.model.StoreCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreCustomerRepository extends JpaRepository<StoreCustomer, Long>, JpaSpecificationExecutor<StoreCustomer> {

}
