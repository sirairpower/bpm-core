package com.tudi.yb.dao;

import com.tudi.yb.model.MnExamOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MnExamOrderRepository extends JpaRepository<MnExamOrder, Long>, JpaSpecificationExecutor<MnExamOrder> {

}
