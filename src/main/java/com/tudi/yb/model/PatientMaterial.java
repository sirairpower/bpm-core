package com.tudi.yb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "patient_material")
public class PatientMaterial implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "material_id", nullable = false)
  private Long materialId;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "out_count", nullable = false)
  private Float outCount;

  @Column(name = "price", nullable = false)
  private Float price;

  @Column(name = "ins_declare_type", nullable = false)
  private Integer insDeclareType;

  @Column(name = "prescription_id", nullable = false)
  private Integer prescriptionId;

}
