package com.tudi.yb.model;

import com.tudi.yb.model.ClinicPhysicalExam.ClinicPhysicalExamPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "clinic_physical_exam")
@IdClass(ClinicPhysicalExamPK.class)
public class ClinicPhysicalExam implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class ClinicPhysicalExamPK implements  Serializable{
    private Long physicalExamId;
    private Long clinicId;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "physical_exam_id", nullable = false)
  private Long physicalExamId;

  @Id
  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

}
