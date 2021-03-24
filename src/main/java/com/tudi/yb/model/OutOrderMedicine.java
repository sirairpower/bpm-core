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
@Table(name = "out_order_medicine")
public class OutOrderMedicine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "out_order_id", nullable = false)
  private Long outOrderId;

  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "package_specification", nullable = false)
  private String packageSpecification;

  @Column(name = "manufacturer", nullable = false)
  private String manufacturer;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "unit_name", nullable = false)
  private String unitName;

  @Column(name = "price", nullable = false)
  private Float price;

}
