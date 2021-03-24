package com.tudi.yb.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "patient")
@Accessors(chain = true)
public class Patient implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ins_id", nullable = false)
  private String insId;

  @Column(name = "identifier", nullable = false)
  private String identifier;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "gender_id", nullable = false)
  private Long genderId;

  @Column(name = "birthday")
  private LocalDate birthday;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "country_id", nullable = false)
  private Long countryId;

  @Column(name = "province_id", nullable = false)
  private Long provinceId;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "treatment_cat_id", nullable = false)
  private Long treatmentCatId;

  @Column(name = "ins_region", nullable = false)
  private String insRegion;

  @Column(name = "history", nullable = false)
  private String history;

  @Column(name = "allergy", nullable = false)
  private String allergy;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "wechat_id")
  private String wechatId;

}
