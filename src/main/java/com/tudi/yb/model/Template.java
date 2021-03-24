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
@Table(name = "template")
public class Template implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @Column(name = "template_type", nullable = false)
  private Integer templateType;

  @Column(name = "category_id", nullable = false)
  private Long categoryId;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "status", nullable = false)
  private Integer status;

}
