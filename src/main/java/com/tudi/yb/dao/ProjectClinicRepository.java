package com.tudi.yb.dao;

import com.tudi.yb.model.ProjectClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectClinicRepository extends JpaRepository<ProjectClinic, Long>, JpaSpecificationExecutor<ProjectClinic> {

}
