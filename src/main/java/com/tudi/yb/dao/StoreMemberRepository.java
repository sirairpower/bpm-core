package com.tudi.yb.dao;

import com.tudi.yb.model.StoreMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreMemberRepository extends JpaRepository<StoreMember, Long>, JpaSpecificationExecutor<StoreMember> {

}
