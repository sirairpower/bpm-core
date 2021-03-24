package com.tudi.yb.model;

import com.tudi.yb.model.ClinicMaterial.ClinicMaterialPK;
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
@Table(name = "clinic_material")
@IdClass(ClinicMaterialPK.class)
public class ClinicMaterial implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class ClinicMaterialPK implements  Serializable{
    private Long clinicId;
    private String materialId;
    private Integer level;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Id
  @Column(name = "material_id", nullable = false)
  private String materialId;

  @Id
  @Column(name = "level", nullable = false)
  private Integer level;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

}
