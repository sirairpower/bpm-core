package com.tudi.yb.model;

import com.tudi.yb.model.OutMedicineHistory.OutMedicineHistoryPK;
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
@Table(name = "out_medicine_history")
@IdClass(OutMedicineHistoryPK.class)
public class OutMedicineHistory implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class OutMedicineHistoryPK implements  Serializable{
    private String version;
    private Long medicineId;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "version", nullable = false)
  private String version;

  @Id
  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

  @Column(name = "cash_back_ratio", nullable = false)
  private Float cashBackRatio;

  @Column(name = "tudi_ratio", nullable = false)
  private Float tudiRatio;

}
