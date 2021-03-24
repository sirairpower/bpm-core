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
@Table(name = "treatment")
public class Treatment implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "treatment_type", nullable = false)
  private Long treatmentType;

  @Column(name = "treatment_unit", nullable = false)
  private String treatmentUnit;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "category_id", nullable = false)
  private Long categoryId;

  @Column(name = "content_type", nullable = false)
  private Integer contentType;

}
