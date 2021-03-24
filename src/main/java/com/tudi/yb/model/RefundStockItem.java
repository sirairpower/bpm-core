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
@Table(name = "refund_stock_item")
public class RefundStockItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_in_id", nullable = false)
  private Long stockInId;

  @Column(name = "stock_in_item_id", nullable = false)
  private Long stockInItemId;

  @Column(name = "item_id", nullable = false)
  private Long itemId;

  @Column(name = "item_type", nullable = false)
  private Integer itemType;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "refund_date", nullable = false)
  private Date refundDate;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Column(name = "actor_id", nullable = false)
  private Integer actorId;

}
