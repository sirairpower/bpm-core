package com.tudi.yb.dao;

import com.tudi.yb.model.StoreMicrofloraOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreMicrofloraOrderRepository extends JpaRepository<StoreMicrofloraOrder, Long>, JpaSpecificationExecutor<StoreMicrofloraOrder> {

}
