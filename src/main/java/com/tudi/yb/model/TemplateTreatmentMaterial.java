package com.tudi.yb.model;

import com.tudi.yb.model.ShareMedicineInsMapping.ShareMedicineInsId;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "template_treatment_material")
public class TemplateTreatmentMaterial implements Serializable {

  private static final long serialVersionUID = 1L;

//  @Column(name = "template_id", nullable = false)
//  private Long templateId;

  @Column(name = "template_treatment_serial_number", nullable = false)
  private Long templateTreatmentSerialNumber;

//  @Column(name = "material_id", nullable = false)
//  private Long materialId;

  @EmbeddedId
  private TemplateTreatmentMaterialId templateTreatmentMaterialId;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Embeddable
  class TemplateTreatmentMaterialId implements Serializable {
    private Long templateId;
    private String materialId;

  }

}
