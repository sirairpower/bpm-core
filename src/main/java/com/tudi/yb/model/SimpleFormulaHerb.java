package com.tudi.yb.model;

import com.tudi.yb.model.SimpleFormulaHerb.SimpleFormulaHerbPK;
import com.tudi.yb.model.TemplateHerb.TemplateHerbPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "simple_formula_herb")
@IdClass(SimpleFormulaHerbPK.class)
public class SimpleFormulaHerb implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class SimpleFormulaHerbPK implements  Serializable{
    private Long formulaId;
    private String name;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "formula_id", nullable = false)
  private Long formulaId;

  @Id
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "dose", nullable = false)
  private Long dose;

  @Column(name = "dose_unit", nullable = false)
  private String doseUnit;

  @Column(name = "priority", nullable = false)
  private Integer priority;

}
