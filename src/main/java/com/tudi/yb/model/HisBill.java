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
@Table(name = "his_bill")
public class HisBill implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "payitem_id", nullable = false)
  private Integer payitemId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "loop_type", nullable = false)
  private Integer loopType;

  @Column(name = "from_date")
  private Date fromDate;

  @Column(name = "to_date")
  private Date toDate;

  @Column(name = "deadline_date", nullable = false)
  private Date deadlineDate;

  @Column(name = "price", nullable = false)
  private Float price;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "pay_time")
  private Date payTime;

}
