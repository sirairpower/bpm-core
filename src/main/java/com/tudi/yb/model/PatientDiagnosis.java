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
@Table(name = "patient_diagnosis")
public class PatientDiagnosis implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "diagnosis_id", nullable = false)
  private Long diagnosisId;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "free_diagnoses", nullable = false)
  private String freeDiagnoses;

}
