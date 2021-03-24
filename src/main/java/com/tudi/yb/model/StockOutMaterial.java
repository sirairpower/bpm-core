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
@Table(name = "stock_out_material")
public class StockOutMaterial implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_out_id", nullable = false)
  private Long stockOutId;

  @Column(name = "material_id", nullable = false)
  private Long materialId;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "price", nullable = false)
  private Float price;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "inventory_id", nullable = false)
  private Long inventoryId;

}
