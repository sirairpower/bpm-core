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
@Table(name = "store_member")
public class StoreMember implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "account", nullable = false)
  private String account;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "referrer", nullable = false)
  private Long referrer;

  @Column(name = "profit_ratio", nullable = false)
  private Float profitRatio;

  @Column(name = "referrer_profit_ratio", nullable = false)
  private Float referrerProfitRatio;

  @Column(name = "status", nullable = false)
  private Integer status;

}
