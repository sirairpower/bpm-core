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
@Table(name = "ins_stock_inventory")
public class InsStockInventory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "resource_type", nullable = false)
  private Integer resourceType;

  @Column(name = "inventory_id", nullable = false)
  private Long inventoryId;

  @Column(name = "platform_kcbh", nullable = false)
  private String platformKcbh;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
