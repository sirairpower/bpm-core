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
@Table(name = "ins_stock_resource")
public class InsStockResource implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "local_id", nullable = false)
  private String localId;

  @Column(name = "resource_type", nullable = false)
  private Integer resourceType;

  @Column(name = "platform_id", nullable = false)
  private String platformId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
