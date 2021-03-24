package com.tudi.yb.model;

import java.io.Serializable;
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
@Table(name = "physical_exam")
public class PhysicalExam implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "data_type", nullable = false)
  private Integer dataType;

  @Column(name = "data_unit", nullable = false)
  private String dataUnit;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "status", nullable = false)
  private Integer status;

}
