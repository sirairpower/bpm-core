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
@Table(name = "db_wd_diagnoses")
public class DbWdDiagnoses implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID;

  @Column(name = "chinese", nullable = false)
  private String chinese;

  @Column(name = "english", nullable = false)
  private String english;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "icd", nullable = false)
  private String icd;

  @Column(name = "xh", nullable = false)
  private Integer xh;

  @Column(name = "project_id", nullable = false)
  private Long projectId;

  @Column(name = "mod_date", nullable = false)
  private Date modDate;

  @Column(name = "approve_status", nullable = false)
  private Integer approveStatus;

  @Column(name = "approve_date")
  private Date approveDate;

  @Column(name = "wish_private", nullable = false)
  private Integer wishPrivate;

  @Column(name = "private", nullable = false)
  private Integer privacy;

  @Column(name = "enable", nullable = false)
  private Integer enable;

}
