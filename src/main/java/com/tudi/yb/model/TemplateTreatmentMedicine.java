package com.tudi.yb.model;

import com.tudi.yb.model.TemplateMedicine.TemplateMedicinePK;
import com.tudi.yb.model.TemplateTreatmentMedicine.TemplateTreatmentMedicinePK;
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
@Table(name = "template_treatment_medicine")
@IdClass(TemplateTreatmentMedicinePK.class)
public class TemplateTreatmentMedicine implements Serializable {
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class TemplateTreatmentMedicinePK implements  Serializable{
    private Long templateId;
    private Long templateTreatmentSerialNumber;
  }
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "template_id", nullable = false)
  private Long templateId;

  @Id
  @Column(name = "template_treatment_serial_number", nullable = false)
  private Long templateTreatmentSerialNumber;

  @Column(name = "medicine_template_id", nullable = false)
  private Long medicineTemplateId;

}
