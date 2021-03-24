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
@Table(name = "sell")
@Accessors(chain = true)
public class Sell implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "sell_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sellId;

  @Column(name = "total_price", nullable = false)
  private Float totalPrice;

  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "sell_time", nullable = false)
  private Date sellTime;

  @Column(name = "pay_method", nullable = false)
  private Integer payMethod;

}
