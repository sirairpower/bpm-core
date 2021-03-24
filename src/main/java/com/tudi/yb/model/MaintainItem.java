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
@Table(name = "maintain_item")
public class MaintainItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "maintain_id", nullable = false)
  private Long maintainId;

  @Column(name = "item_id", nullable = false)
  private Long itemId;

  @Column(name = "batch_number", nullable = false)
  private String batchNumber;

  @Column(name = "inventory_id", nullable = false)
  private Long inventoryId;

  @Column(name = "result_type", nullable = false)
  private Integer resultType;

  @Column(name = "drop_count", nullable = false)
  private Float dropCount;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

}
