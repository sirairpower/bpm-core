package com.tudi.yb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "share_medicine_ins_mapping")
public class ShareMedicineInsMapping implements Serializable {

  private static final long serialVersionUID = 1L;

//  @Column(name = "medicine_id", nullable = false)
//  private Long medicineId;

  @Column(name = "ins_type", nullable = false)
  private Integer insType;

//  @Column(name = "ins_id", nullable = false)
//  private String insId;

  @Column(name = "stock_type", nullable = false)
  private Integer stockType;

  @EmbeddedId
  private ShareMedicineInsId shareMedicineInsId;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Embeddable
  class ShareMedicineInsId implements Serializable {
    private Long medicineId;
    private String insId;

  }

}
