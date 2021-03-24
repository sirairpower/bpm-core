package com.tudi.yb.dao;

import com.tudi.yb.model.Counting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CountingRepository extends JpaRepository<Counting, Long>, JpaSpecificationExecutor<Counting> {

}
