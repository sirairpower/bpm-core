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
@Table(name = "patient_paste")
public class PatientPaste implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "stock_type", nullable = false)
  private Integer stockType;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "form", nullable = false)
  private Integer form;

  @Column(name = "package_type", nullable = false)
  private Integer packageType;

  @Column(name = "is_send_residue", nullable = false)
  private Boolean sendResidue;

  @Column(name = "advice", nullable = false)
  private String advice;

  @Column(name = "is_print_prescription", nullable = false)
  private Boolean printPrescription;

}
