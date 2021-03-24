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
@Table(name = "refund_in_item")
public class RefundInItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "refund_in_id", nullable = false)
  private Long refundInId;

  @Column(name = "item_type", nullable = false)
  private Integer itemType;

  @Column(name = "item_id", nullable = false)
  private Long itemId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "inventory_id", nullable = false)
  private Long inventoryId;

  @Column(name = "stock_out_item_id", nullable = false)
  private Long stockOutItemId;

}
