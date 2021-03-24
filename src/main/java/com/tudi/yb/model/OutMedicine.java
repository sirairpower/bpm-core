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
@Table(name = "out_medicine")
public class OutMedicine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "out_id", nullable = false)
  private String outId;

  @Column(name = "store_id", nullable = false)
  private Long storeId;

  @Column(name = "medicine_type", nullable = false)
  private Integer medicineType;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "fivecode")
  private String fivecode;

  @Column(name = "package_specification", nullable = false)
  private String packageSpecification;

  @Column(name = "origin", nullable = false)
  private String origin;

  @Column(name = "manufacturer", nullable = false)
  private String manufacturer;

  @Column(name = "package_unit", nullable = false)
  private String packageUnit;

  @Column(name = "package_count", nullable = false)
  private Long packageCount;

  @Column(name = "out_unit", nullable = false)
  private Long outUnit;

  @Column(name = "min_unit", nullable = false)
  private String minUnit;

  @Column(name = "safe_count", nullable = false)
  private Float safeCount;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

  @Column(name = "cash_back_ratio", nullable = false)
  private Float cashBackRatio;

  @Column(name = "tudi_ratio", nullable = false)
  private Float tudiRatio;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "herb_usage_type", nullable = false)
  private Integer herbUsageType;

}
