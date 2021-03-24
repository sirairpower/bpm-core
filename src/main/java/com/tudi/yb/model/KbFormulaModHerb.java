package com.tudi.yb.model;

import com.tudi.yb.model.KbFormulaModHerb.KbFormulaModHerbId;
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
@Table(name = "kb_formula_mod_herb")
@IdClass(KbFormulaModHerbId.class)
public class KbFormulaModHerb implements Serializable {
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class KbFormulaModHerbId implements  Serializable{
    private Long formulaModId;
    private Long herbId;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "formula_mod_id", nullable = false)
  private Long formulaModId;

  @Id
  @Column(name = "herb_id", nullable = false)
  private Long herbId;

  @Column(name = "mod_type", nullable = false)
  private Integer modType;

  @Column(name = "min_count", nullable = false)
  private Float minCount;

  @Column(name = "max_count", nullable = false)
  private Float maxCount;

  @Column(name = "priority", nullable = false)
  private Long priority;

}
