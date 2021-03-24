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
@Table(name = "stock_out")
public class StockOut implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_out_type", nullable = false)
  private Long stockOutType;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "sell_id", nullable = false)
  private Long sellId;

  @Column(name = "requisition_id", nullable = false)
  private Long requisitionId;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
