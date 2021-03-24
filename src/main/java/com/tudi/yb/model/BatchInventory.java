package com.tudi.yb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "batch_inventory")
public class BatchInventory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "batch_number", nullable = false)
  private String batchNumber;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
