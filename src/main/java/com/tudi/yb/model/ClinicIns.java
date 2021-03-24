package com.tudi.yb.model;

import com.tudi.yb.model.ClinicIns.ClinicInsPK;
import com.tudi.yb.model.SimpleFormulaHerb.SimpleFormulaHerbPK;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "clinic_ins")
@IdClass(ClinicInsPK.class)
public class ClinicIns implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class ClinicInsPK implements  Serializable{
    private Long clinicId;
    private Integer insType;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Id
  @Column(name = "ins_type", nullable = false)
  private Integer insType;

  @Column(name = "clinic_ins_id", nullable = false)
  private String clinicInsId;

  @Column(name = "operator_id", nullable = false)
  private String operatorId;

  @Column(name = "operator_name", nullable = false)
  private String operatorName;

  @Column(name = "operator_serial", nullable = false)
  private String operatorSerial;

  @Column(name = "operator_serial_time")
  private Date operatorSerialTime;

  @Column(name = "enable_time")
  private Date enableTime;

  @Column(name = "area_code", nullable = false)
  private String areaCode;

  @Column(name = "ins_ip", nullable = false)
  private String insIp;

  @Column(name = "wn_stock_id")
  private String wnStockId;

  @Column(name = "major_machine_ip")
  private String majorMachineIp;

}
