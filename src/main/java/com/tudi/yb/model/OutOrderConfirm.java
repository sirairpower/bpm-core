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
@Table(name = "out_order_confirm")
public class OutOrderConfirm implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "from_time", nullable = false)
  private Date fromTime;

  @Column(name = "to_time", nullable = false)
  private Date toTime;

  @Column(name = "count", nullable = false)
  private Integer count;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "service_id", nullable = false)
  private Integer serviceId;

  @Column(name = "finish_time", nullable = false)
  private Date finishTime;

}
