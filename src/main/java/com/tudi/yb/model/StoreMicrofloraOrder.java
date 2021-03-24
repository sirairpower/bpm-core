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
@Table(name = "store_microflora_order")
public class StoreMicrofloraOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @Column(name = "customer_id", nullable = false)
  private Long customerId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "gender", nullable = false)
  private Integer gender;

  @Column(name = "age_type", nullable = false)
  private Integer ageType;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "address_province", nullable = false)
  private String addressProvince;

  @Column(name = "address_city", nullable = false)
  private String addressCity;

  @Column(name = "address_region", nullable = false)
  private String addressRegion;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "bill_id", nullable = false)
  private Long billId;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
