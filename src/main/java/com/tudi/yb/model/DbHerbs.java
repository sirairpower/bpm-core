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
@Table(name = "db_herbs")
public class DbHerbs implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID;

  @Column(name = "pinyin")
  private String pinyin;

  @Column(name = "unit", nullable = false)
  private String unit;

  @Column(name = "categoryID", nullable = false)
  private Long categoryID;

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

  @Column(name = "desc_en", nullable = false)
  private String descEn;

  @Column(name = "desc_cn", nullable = false)
  private String descCn;

  @Column(name = "wei", nullable = false)
  private String wei;

  @Column(name = "xing", nullable = false)
  private String xing;

  @Column(name = "channels", nullable = false)
  private String channels;

  @Column(name = "treatments", nullable = false)
  private String treatments;

}
