package com.tudi.yb.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "material_inventory")
public class MaterialInventory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "material_id", nullable = false)
  private Long materialId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "batch_number", nullable = false)
  private String batchNumber;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
