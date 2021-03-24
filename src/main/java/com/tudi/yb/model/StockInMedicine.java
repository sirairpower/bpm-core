package com.tudi.yb.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "stock_in_medicine")
public class StockInMedicine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_in_id", nullable = false)
  private Long stockInId;

  @Column(name = "medicine_id", nullable = false)
  private Long medicineId;

  @Column(name = "count", nullable = false)
  private Float count;

  @Column(name = "batch_number", nullable = false)
  private String batchNumber;

  @Column(name = "manufacturing_date")
  private LocalDate manufacturingDate;

  @Column(name = "expiration_date")
  private LocalDate expirationDate;

  @Column(name = "in_price", nullable = false)
  private Float inPrice;

  @Column(name = "out_price", nullable = false)
  private Float outPrice;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

}
