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
@Table(name = "patient_mn_exam")
public class PatientMnExam implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "book_date")
  private Date bookDate;

  @Column(name = "patient_name", nullable = false)
  private String patientName;

  @Column(name = "gender_id", nullable = false)
  private Integer genderId;

  @Column(name = "marriage", nullable = false)
  private Integer marriage;

  @Column(name = "identifier", nullable = false)
  private String identifier;

  @Column(name = "phone", nullable = false)
  private String phone;

}
