package com.tudi.yb.dao;

import com.tudi.yb.model.Paiditem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaiditemRepository extends JpaRepository<Paiditem, Long>, JpaSpecificationExecutor<Paiditem> {

}
