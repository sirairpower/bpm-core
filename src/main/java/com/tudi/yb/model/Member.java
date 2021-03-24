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
@Table(name = "member")
@Accessors(chain = true)
public class Member implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "account", nullable = false)
  private String account;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "role_id", nullable = false)
  private Long roleId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "create_time")
  private Date createTime;

}
