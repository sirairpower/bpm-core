package com.tudi.yb.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "stock_in")
public class StockIn implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_in_type", nullable = false)
  private Long stockInType;

  @Column(name = "supplier", nullable = false)
  private String supplier;

  @Column(name = "receipt_date")
  private LocalDate receiptDate;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "acceptor_id", nullable = false)
  private Long acceptorId;

  @Column(name = "reviewer_id", nullable = false)
  private Long reviewerId;

  @Column(name = "total_in_price", nullable = false)
  private Float totalInPrice;

}
