package com.tudi.yb.model;

import com.tudi.yb.model.OutOrderDiagnosis.OutOrderDiagnosisPK;
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
@Table(name = "out_order_diagnosis")
@IdClass(OutOrderDiagnosisPK.class)
public class OutOrderDiagnosis implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class OutOrderDiagnosisPK implements  Serializable{
    private Long outOrderId;
    private Integer priority;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "out_order_id", nullable = false)
  private Long outOrderId;

  @Id
  @Column(name = "priority", nullable = false)
  private Integer priority;

  @Column(name = "ins_id", nullable = false)
  private String insId;

  @Column(name = "name", nullable = false)
  private String name;

}
