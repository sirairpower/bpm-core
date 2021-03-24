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
@Table(name = "sell_item")
public class SellItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "sell_item_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sellItemId;

  @Column(name = "sell_id", nullable = false)
  private Long sellId;

  @Column(name = "sell_type", nullable = false)
  private Integer sellType;

  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "batch_number", nullable = false)
  private String batchNumber;

  @Column(name = "out_unit", nullable = false)
  private Integer outUnit;

  @Column(name = "out_price", nullable = false)
  private Double outPrice;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "final_out_price", nullable = false)
  private Double finalOutPrice;

  @Column(name = "status", nullable = false)
  private Integer status;

}
