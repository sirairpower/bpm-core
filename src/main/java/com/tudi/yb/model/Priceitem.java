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
@Accessors(chain = true)
@Table(name = "priceitem")
public class Priceitem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "except", nullable = false)
  private String except;

  @Column(name = "unit", nullable = false)
  private String unit;

  @Column(name = "price", nullable = false)
  private Float price;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "category_id", nullable = false)
  private String categoryId;

}
