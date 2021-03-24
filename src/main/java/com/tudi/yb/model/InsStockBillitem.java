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
@Table(name = "ins_stock_billitem")
public class InsStockBillitem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "stock_bill_id", nullable = false)
  private Integer stockBillId;

  @Column(name = "local_item_id", nullable = false)
  private String localItemId;

  @Column(name = "item_type", nullable = false)
  private Integer itemType;

  @Column(name = "platform_id", nullable = false)
  private String platformId;

}
