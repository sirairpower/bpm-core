package com.tudi.yb.dao;

import com.tudi.yb.model.HerbDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HerbDictionaryRepository extends JpaRepository<HerbDictionary, Long>, JpaSpecificationExecutor<HerbDictionary> {

}
