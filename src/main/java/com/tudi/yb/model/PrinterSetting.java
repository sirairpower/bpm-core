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
@Table(name = "printer_setting")
public class PrinterSetting implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "printer_id", nullable = false)
  private Integer printerId;

  @Column(name = "clinic_id", nullable = false)
  private Integer clinicId;

  @Column(name = "print_type", nullable = false)
  private Integer printType;

  @Column(name = "is_default", nullable = false)
  private Boolean isDefault;

  @Column(name = "paper_name", nullable = false)
  private String paperName;

  @Column(name = "paper_width", nullable = false)
  private Integer paperWidth;

  @Column(name = "paper_height", nullable = false)
  private Integer paperHeight;

  @Column(name = "margin_top", nullable = false)
  private Integer marginTop;

  @Column(name = "margin_left", nullable = false)
  private Integer marginLeft;

}
