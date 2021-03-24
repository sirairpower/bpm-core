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
@Table(name = "ins_supplier")
public class InsSupplier implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "ins_id", nullable = false)
  private String insId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "certificate_id", nullable = false)
  private String certificateId;

  @Column(name = "supplier_type", nullable = false)
  private Integer supplierType;

  @Column(name = "ins_company_id", nullable = false)
  private String insCompanyId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

}
