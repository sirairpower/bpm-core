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
@Table(name = "store_customer")
public class StoreCustomer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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

}
