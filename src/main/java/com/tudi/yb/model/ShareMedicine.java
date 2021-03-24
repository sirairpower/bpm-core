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
@Table(name = "share_medicine")
public class ShareMedicine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

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
  private Long timesOfDay;

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

  @Column(name = "info_from", nullable = false)
  private Long infoFrom;

  @Column(name = "source_id", nullable = false)
  private String sourceId;

  @Column(name = "barcode", nullable = false)
  private String barcode;

}
