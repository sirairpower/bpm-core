package com.tudi.yb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "doctor")
@Accessors(chain = true)
public class Doctor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @Column(name = "ins_id", nullable = false)
  private String insId;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "multisite", nullable = false)
  private Integer multisite;

  @Column(name = "proxy_id", nullable = false)
  private Long proxyId;

}
