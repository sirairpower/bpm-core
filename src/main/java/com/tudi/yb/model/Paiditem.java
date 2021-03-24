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
@Table(name = "paiditem")
public class Paiditem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ins_id", nullable = false)
  private String insId;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "five_code", nullable = false)
  private String fiveCode;

  @Column(name = "item_type", nullable = false)
  private Long itemType;

  @Column(name = "ins_payment_class", nullable = false)
  private Long insPaymentClass;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "standard_price", nullable = false)
  private Float standardPrice;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

}
