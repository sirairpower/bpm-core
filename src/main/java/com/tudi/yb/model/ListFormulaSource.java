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
@Table(name = "list_formula_source")
public class ListFormulaSource implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "sourceID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer sourceID;

  @Column(name = "english", nullable = false)
  private String english;

  @Column(name = "chinese", nullable = false)
  private String chinese;

  @Column(name = "classical", nullable = false)
  private String classical;

  @Column(name = "doctorID", nullable = false)
  private Integer doctorID;

}
