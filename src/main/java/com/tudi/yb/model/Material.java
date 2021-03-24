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
@Table(name = "material")
public class Material implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "package_specification", nullable = false)
  private String packageSpecification;

  @Column(name = "manufacturer", nullable = false)
  private String manufacturer;

  @Column(name = "package_unit", nullable = false)
  private String packageUnit;

  @Column(name = "priceitem_id", nullable = false)
  private String priceitemId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

}
