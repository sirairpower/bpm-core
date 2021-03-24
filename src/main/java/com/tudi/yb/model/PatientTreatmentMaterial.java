package com.tudi.yb.model;

import com.tudi.yb.model.PatientTreatmentMaterial.PatientTreatmentMaterialPK;
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
@Table(name = "patient_treatment_material")
@IdClass(PatientTreatmentMaterialPK.class)
public class PatientTreatmentMaterial implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class PatientTreatmentMaterialPK implements  Serializable{
    private Long patientTreatmentId;
    private Long materialId;
    private Long serialNumber;
  }


  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "patient_treatment_id", nullable = false)
  private Long patientTreatmentId;

  @Id
  @Column(name = "material_id", nullable = false)
  private Long materialId;

  @Id
  @Column(name = "serial_number", nullable = false)
  private Long serialNumber;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "price", nullable = false)
  private Float price;

}
