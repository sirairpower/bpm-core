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
@Table(name = "counting_medicine")
public class CountingMedicine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "counting_id", nullable = false)
  private Long countingId;

  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Column(name = "type", nullable = false)
  private Integer type;

  @Column(name = "original_count", nullable = false)
  private Float originalCount;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

  @Column(name = "inventory_id", nullable = false)
  private Long inventoryId;

  @Column(name = "item_type", nullable = false)
  private Integer itemType;

}
