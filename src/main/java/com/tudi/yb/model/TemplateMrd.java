package com.tudi.yb.model;

import com.tudi.yb.model.TemplateMrd.TemplateMrdPK;
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
@Table(name = "template_mrd")
@IdClass(TemplateMrdPK.class)
public class TemplateMrd implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class TemplateMrdPK implements  Serializable{
    private Integer templateId;
    private Integer diagnosisId;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "template_id", nullable = false)
  private Integer templateId;

  @Id
  @Column(name = "diagnosis_id", nullable = false)
  private Integer diagnosisId;

  @Column(name = "free_diagnoses")
  private String freeDiagnoses;

}
