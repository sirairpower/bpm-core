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
@Table(name = "bill_price_item")
public class BillPriceItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "bill_id", nullable = false)
  private Long billId;

  @Column(name = "item_type", nullable = false)
  private Integer itemType;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "unit_name", nullable = false)
  private String unitName;

  @Column(name = "total_price", nullable = false)
  private Float totalPrice;

  @Column(name = "specification", nullable = false)
  private String specification;

  @Column(name = "insurance_level", nullable = false)
  private Integer insuranceLevel;

  @Column(name = "selfpay_ratio", nullable = false)
  private Float selfpayRatio;

  @Column(name = "prescription_id", nullable = false)
  private Long prescriptionId;

  @Column(name = "formula_count", nullable = false)
  private Long formulaCount;

  @Column(name = "ins_declare_type", nullable = false)
  private Integer insDeclareType;

}
