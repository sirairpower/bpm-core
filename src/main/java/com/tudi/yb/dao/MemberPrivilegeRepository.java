package com.tudi.yb.dao;

import com.tudi.yb.model.MemberPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberPrivilegeRepository extends JpaRepository<MemberPrivilege, Long>, JpaSpecificationExecutor<MemberPrivilege> {

}
