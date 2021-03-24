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
@Table(name = "maintain")
public class Maintain implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "maintain_type", nullable = false)
  private Integer maintainType;

  @Column(name = "item_type", nullable = false)
  private Integer itemType;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "maintainer_id", nullable = false)
  private Long maintainerId;

  @Column(name = "reviewer_id", nullable = false)
  private Long reviewerId;

  @Column(name = "maintain_date", nullable = false)
  private Date maintainDate;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
