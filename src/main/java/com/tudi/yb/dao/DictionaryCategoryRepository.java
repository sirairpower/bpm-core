package com.tudi.yb.dao;

import com.tudi.yb.model.DictionaryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DictionaryCategoryRepository extends JpaRepository<DictionaryCategory, Long>, JpaSpecificationExecutor<DictionaryCategory> {

}
