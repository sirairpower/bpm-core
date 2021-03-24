package com.tudi.yb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "wx_patient")
public class WxPatient implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "open_id", nullable = false)
  private String openId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "gender_id", nullable = false)
  private Integer genderId;

  @Column(name = "birthday")
  private Date birthday;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "patient_id", nullable = false)
  private Long patientId;

}
