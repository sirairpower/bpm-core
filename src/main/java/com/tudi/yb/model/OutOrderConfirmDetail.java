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
@Table(name = "out_order_confirm_detail")
public class OutOrderConfirmDetail implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "confirm_id", nullable = false)
  private Long confirmId;

  @Column(name = "order_id", nullable = false)
  private String orderId;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "order_time")
  private Date orderTime;

  @Column(name = "local_json", nullable = false)
  private String localJson;

  @Column(name = "remote_json", nullable = false)
  private String remoteJson;

}
