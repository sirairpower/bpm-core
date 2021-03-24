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
@Table(name = "ins_stock_bill")
public class InsStockBill implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "bill_type", nullable = false)
  private Integer billType;

  @Column(name = "local_bill_id", nullable = false)
  private Long localBillId;

  @Column(name = "platform_bill_id", nullable = false)
  private String platformBillId;

  @Column(name = "platform_record_id", nullable = false)
  private String platformRecordId;

  @Column(name = "clinic_id", nullable = false)
  private Integer clinicId;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
