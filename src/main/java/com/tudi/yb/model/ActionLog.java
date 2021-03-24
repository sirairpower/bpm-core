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
@Table(name = "action_log")
public class ActionLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "log_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long logId;

  @Column(name = "account", nullable = false)
  private String account;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "page", nullable = false)
  private String page;

  @Column(name = "op", nullable = false)
  private String op;

  @Column(name = "action_time", nullable = false)
  private Date actionTime;

  @Column(name = "param", nullable = false)
  private String param;

}
