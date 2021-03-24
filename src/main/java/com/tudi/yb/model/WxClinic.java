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
@Accessors(chain = true)
@Table(name = "wx_clinic")
public class WxClinic implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "appid", nullable = false)
  private String appid;

  @Column(name = "appsecret", nullable = false)
  private String appsecret;

}
