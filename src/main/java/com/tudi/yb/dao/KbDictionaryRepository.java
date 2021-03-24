package com.tudi.yb.dao;

import com.tudi.yb.model.KbDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KbDictionaryRepository extends JpaRepository<KbDictionary, Long>, JpaSpecificationExecutor<KbDictionary> {

}
