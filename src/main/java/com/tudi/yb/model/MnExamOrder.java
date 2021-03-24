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
@Table(name = "mn_exam_order")
public class MnExamOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_id", nullable = false)
  private String orderId;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "book_date", nullable = false)
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

  @Column(name = "total_in_price", nullable = false)
  private Float totalInPrice;

  @Column(name = "total_out_price", nullable = false)
  private Float totalOutPrice;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
