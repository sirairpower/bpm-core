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
@Table(name = "diagnosis")
public class Diagnosis implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ins_id", nullable = false)
  private String insId;

  @Column(name = "diagnosis_type", nullable = false)
  private Integer diagnosisType;

  @Column(name = "code_type", nullable = false)
  private Integer codeType;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pinyin")
  private String pinyin;

  @Column(name = "five_code", nullable = false)
  private String fiveCode;

  @Column(name = "start_time")
  private Date startTime;

  @Column(name = "finish_time")
  private Date finishTime;

}
