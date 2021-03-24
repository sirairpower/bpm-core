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
@Table(name = "wxpay_demo_transaction")
public class WxpayDemoTransaction implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "trade_no", nullable = false)
  private String tradeNo;

  @Column(name = "price", nullable = false)
  private Float price;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "pay_desc", nullable = false)
  private String payDesc;

  @Column(name = "response_text", nullable = false)
  private String responseText;

}
