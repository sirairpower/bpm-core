package com.tudi.yb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "mn_exam")
@Accessors(chain = true)
public class MnExam implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "out_id", nullable = false)
  private String outId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

  @Column(name = "in_price", nullable = false)
  private Float inPrice;

  @Column(name = "is_package", nullable = false)
  private Boolean isPackage;

  @Column(name = "category_id", nullable = false)
  private Integer categoryId;

}
