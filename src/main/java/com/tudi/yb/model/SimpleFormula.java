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
@Table(name = "simple_formula")
public class SimpleFormula implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "pinyin", nullable = false)
  private String pinyin;

  @Column(name = "source", nullable = false)
  private String source;

  @Column(name = "func", nullable = false)
  private String func;

  @Column(name = "symptom", nullable = false)
  private String symptom;

  @Column(name = "formula_usage", nullable = false)
  private String formulaUsage;

  @Column(name = "category_id", nullable = false)
  private Long categoryId;

}
