package com.tudi.yb.model;

import com.tudi.yb.model.MedicineInsMapping.MedicineInsMappingPK;
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
@Table(name = "medicine_ins_mapping")
@IdClass(MedicineInsMappingPK.class)
public class MedicineInsMapping implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class MedicineInsMappingPK implements  Serializable{
    private Long medicineId;
    private Integer insType;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Id
  @Column(name = "ins_type", nullable = false)
  private Integer insType;

  @Column(name = "ins_id")
  private String insId;

}
