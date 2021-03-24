package com.tudi.yb.dao;

import com.tudi.yb.model.DbHerbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DbHerbsRepository extends JpaRepository<DbHerbs, Long>, JpaSpecificationExecutor<DbHerbs> {

}
