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
@Table(name = "patient_medicine")
public class PatientMedicine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Column(name = "stock_type", nullable = false)
  private Long stockType;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "days", nullable = false)
  private Long days;

  @Column(name = "dose", nullable = false)
  private String dose;

  @Column(name = "out_count", nullable = false)
  private Float outCount;

  @Column(name = "out_unit", nullable = false)
  private Integer outUnit;

  @Column(name = "menu_usage_id", nullable = false)
  private Long menuUsageId;

  @Column(name = "menu_freq_id", nullable = false)
  private Long menuFreqId;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "ins_declare_type", nullable = false)
  private Integer insDeclareType;

  @Column(name = "group_num", nullable = false)
  private Integer groupNum;

  @Column(name = "prescription_id", nullable = false)
  private Integer prescriptionId;

}
