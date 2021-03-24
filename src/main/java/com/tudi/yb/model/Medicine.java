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
@Table(name = "medicine")
public class Medicine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "fivecode")
  private String fivecode;

  @Column(name = "medicine_type", nullable = false)
  private Integer medicineType;

  @Column(name = "manufacturer", nullable = false)
  private String manufacturer;

  @Column(name = "origin", nullable = false)
  private String origin;

  @Column(name = "menu_freq_id", nullable = false)
  private Long menuFreqId;

  @Column(name = "menu_usage_id", nullable = false)
  private Long menuUsageId;

  @Column(name = "times_of_day", nullable = false)
  private Integer timesOfDay;

  @Column(name = "package_unit", nullable = false)
  private String packageUnit;

  @Column(name = "package_specification", nullable = false)
  private String packageSpecification;

  @Column(name = "package_count", nullable = false)
  private Long packageCount;

  @Column(name = "standard_dose", nullable = false)
  private String standardDose;

  @Column(name = "formulation_id", nullable = false)
  private Long formulationId;

  @Column(name = "min_unit", nullable = false)
  private String minUnit;

  @Column(name = "approval_id", nullable = false)
  private String approvalId;

  @Column(name = "barcode", nullable = false)
  private String barcode;

  @Column(name = "share_medicine_id", nullable = false)
  private Long shareMedicineId;

  @Column(name = "out_price", nullable = false)
  private Double outPrice;

  @Column(name = "out_unit", nullable = false)
  private Integer outUnit;

  @Column(name = "safe_count", nullable = false)
  private Float safeCount;

  @Column(name = "medicine_status", nullable = false)
  private Integer medicineStatus;

  @Column(name = "medicine_remark", nullable = false)
  private String medicineRemark;

}
