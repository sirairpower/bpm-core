package com.tudi.yb.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "stock_in_material")
public class StockInMaterial implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_in_id", nullable = false)
  private Long stockInId;

  @Column(name = "material_id", nullable = false)
  private Long materialId;

  @Column(name = "priceitem_id")
  private String priceitemId;

  @Column(name = "package_specification", nullable = false)
  private String packageSpecification;

  @Column(name = "manufacturer", nullable = false)
  private String manufacturer;

  @Column(name = "batch_number", nullable = false)
  private String batchNumber;

  @Column(name = "expiration_date")
  private LocalDate expirationDate;

  @Column(name = "unit", nullable = false)
  private String unit;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "in_price", nullable = false)
  private Float inPrice;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

}
