package com.tudi.yb.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "store_bill")
public class StoreBill implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @Column(name = "referrer_id", nullable = false)
  private Long referrerId;

  @Column(name = "product_type", nullable = false)
  private Integer productType;

  @Column(name = "customer_id", nullable = false)
  private Long customerId;

  @Column(name = "total_price", nullable = false)
  private Float totalPrice;

  @Column(name = "profit_ratio", nullable = false)
  private Float profitRatio;

  @Column(name = "referrer_profit_ratio", nullable = false)
  private Float referrerProfitRatio;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
