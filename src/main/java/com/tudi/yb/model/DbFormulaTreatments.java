package com.tudi.yb.model;

import com.tudi.yb.model.DbFormulaTreatments.DbFormulaTreatmentsPK;
import com.tudi.yb.model.KbFormulaModPattern.KbFormulaModPatternPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "db_formula_treatments")
@IdClass(DbFormulaTreatmentsPK.class)
public class DbFormulaTreatments implements Serializable {

  private static final long serialVersionUID = 1L;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class DbFormulaTreatmentsPK implements  Serializable{
    private Integer formulaID;
    private Integer treatmentID;
  }

  @Id
  @Column(name = "formulaID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer formulaID;

  @Id
  @Column(name = "treatmentID", nullable = false)
  private Integer treatmentID;

}
