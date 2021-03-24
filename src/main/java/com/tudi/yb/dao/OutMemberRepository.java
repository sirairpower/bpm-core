package com.tudi.yb.dao;

import com.tudi.yb.model.OutMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OutMemberRepository extends JpaRepository<OutMember, Long>, JpaSpecificationExecutor<OutMember> {

}
