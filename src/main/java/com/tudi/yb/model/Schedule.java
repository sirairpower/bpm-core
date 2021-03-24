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
@Accessors(chain = true)
@Table(name = "schedule")
public class Schedule implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "schedule_type", nullable = false)
  private Integer scheduleType;

  @Column(name = "division_id", nullable = false)
  private Long divisionId;

  @Column(name = "registration_fee", nullable = false)
  private Float registrationFee;

  @Column(name = "inquiry_fee", nullable = false)
  private Float inquiryFee;

  @Column(name = "count_limit", nullable = false)
  private Long countLimit;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "doctor_member_id", nullable = false)
  private Long doctorMemberId;

  @Column(name = "room", nullable = false)
  private String room;

  @Column(name = "weekday", nullable = false)
  private Long weekday;

  @Column(name = "shift", nullable = false)
  private Integer shift;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

}
