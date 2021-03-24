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
@Table(name = "out_order")
public class OutOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "medicine_type", nullable = false)
  private Integer medicineType;

  @Column(name = "is_cook", nullable = false)
  private Boolean cook;

  @Column(name = "is_deliver", nullable = false)
  private Boolean deliver;

  @Column(name = "deliver_address", nullable = false)
  private String deliverAddress;

  @Column(name = "store_id", nullable = false)
  private Long storeId;

  @Column(name = "order_id", nullable = false)
  private String orderId;

  @Column(name = "clinic_id", nullable = false)
  private Integer clinicId;

  @Column(name = "clinic_name", nullable = false)
  private String clinicName;

  @Column(name = "clinic_address", nullable = false)
  private String clinicAddress;

  @Column(name = "clinic_phone", nullable = false)
  private String clinicPhone;

  @Column(name = "patient_name", nullable = false)
  private String patientName;

  @Column(name = "patient_phone", nullable = false)
  private String patientPhone;

  @Column(name = "doctor_name", nullable = false)
  private String doctorName;

  @Column(name = "doctor_id", nullable = false)
  private String doctorId;

  @Column(name = "count", nullable = false)
  private Long count;

  @Column(name = "remark", nullable = false)
  private String remark;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "price", nullable = false)
  private Float price;

  @Column(name = "deliver_fee", nullable = false)
  private Float deliverFee;

  @Column(name = "cook_fee", nullable = false)
  private Float cookFee;

  @Column(name = "package_fee", nullable = false)
  private Float packageFee;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Column(name = "last_modify_time", nullable = false)
  private Date lastModifyTime;

  @Column(name = "version", nullable = false)
  private String version;

}
