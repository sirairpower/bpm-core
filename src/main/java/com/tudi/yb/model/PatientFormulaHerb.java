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
@Table(name = "patient_formula_herb")
public class PatientFormulaHerb implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_type", nullable = false)
  private Long stockType;

  @Column(name = "patient_formula_id", nullable = false)
  private Long patientFormulaId;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "menu_cooktype_id", nullable = false)
  private Long menuCooktypeId;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "ins_declare_type", nullable = false)
  private Integer insDeclareType;

}
