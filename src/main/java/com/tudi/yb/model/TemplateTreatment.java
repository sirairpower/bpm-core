package com.tudi.yb.model;

import com.tudi.yb.model.TemplateMedicine.TemplateMedicinePK;
import com.tudi.yb.model.TemplateTreatment.TemplateTreatmentPK;
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
@Table(name = "template_treatment")
@IdClass(TemplateTreatmentPK.class)
public class TemplateTreatment implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class TemplateTreatmentPK implements  Serializable{
    private Long templateId;
    private Long serialNumber;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "template_id", nullable = false)
  private Long templateId;

  @Id
  @Column(name = "serial_number", nullable = false)
  private Long serialNumber;

  @Column(name = "treatment_id", nullable = false)
  private Long treatmentId;

  @Column(name = "count", nullable = false)
  private Long count;

  @Column(name = "remark", nullable = false)
  private String remark;

}
