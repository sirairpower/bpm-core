package com.tudi.yb.model;

import com.tudi.yb.model.InsMedicine.InsMedicinePK;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "ins_medicine")
@IdClass(InsMedicinePK.class)
public class InsMedicine implements Serializable {
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class InsMedicinePK implements  Serializable{
    private String insId;
    private Integer type;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ins_id", nullable = false)
  private String insId;

  @Id
  @Column(name = "type", nullable = false)
  private Integer type;

  @Column(name = "serial_number")
  private Long serialNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "eng_name", nullable = false)
  private String engName;

  @Column(name = "generic_name", nullable = false)
  private String genericName;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "package_material")
  private String packageMaterial;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "medicine_type", nullable = false)
  private Integer medicineType;

  @Column(name = "insurance_level", nullable = false)
  private Integer insuranceLevel;

  @Column(name = "manufacturer", nullable = false)
  private String manufacturer;

  @Column(name = "package_unit", nullable = false)
  private String packageUnit;

  @Column(name = "package_specification", nullable = false)
  private String packageSpecification;

  @Column(name = "package_count", nullable = false)
  private Long packageCount;

  @Column(name = "formulation_id", nullable = false)
  private Long formulationId;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "start_time")
  private Date startTime;

  @Column(name = "finish_time")
  private Date finishTime;

  @Column(name = "max_out_price", nullable = false)
  private Double maxOutPrice;

  @Column(name = "selfpay_ratio", nullable = false)
  private Float selfpayRatio;

  @Column(name = "status", nullable = false)
  private Integer status;

}
