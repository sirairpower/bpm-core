package com.tudi.yb.model;

import com.tudi.yb.model.KbFormulaModHerb.KbFormulaModHerbId;
import com.tudi.yb.model.KbFormulaModPattern.KbFormulaModPatternPK;
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
@Table(name = "kb_formula_mod_pattern")
@IdClass(KbFormulaModPatternPK.class)
public class KbFormulaModPattern implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class KbFormulaModPatternPK implements  Serializable{
    private Long formulaModId;
    private Long patternId;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "formula_mod_id", nullable = false)
  private Long formulaModId;

  @Id
  @Column(name = "pattern_id", nullable = false)
  private Long patternId;

}
