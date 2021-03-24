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
@Table(name = "ins_transaction")
public class InsTransaction implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "transaction_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long transactionId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "ins_type", nullable = false)
  private Integer insType;

  @Column(name = "business_code", nullable = false)
  private String businessCode;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Column(name = "update_time", nullable = false)
  private Date updateTime;

  @Column(name = "operator_serial", nullable = false)
  private String operatorSerial;

  @Column(name = "bill_id", nullable = false)
  private Long billId;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "input", nullable = false)
  private String input;

  @Column(name = "output", nullable = false)
  private String output;

}
