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
@Table(name = "clinic")
@Accessors(chain = true)
public class Clinic implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "clinic_code", nullable = false)
  private String clinicCode;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "owner", nullable = false)
  private String owner;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "wechat_id", nullable = false)
  private String wechatId;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "registration_info", nullable = false)
  private String registrationInfo;

  @Column(name = "can_room_reg", nullable = false)
  private Integer canRoomReg;

  @Column(name = "shift_type", nullable = false)
  private Integer shiftType;

  @Column(name = "first_shift_start_hour", nullable = false)
  private Integer firstShiftStartHour;

  @Column(name = "first_shift_finish_hour", nullable = false)
  private Integer firstShiftFinishHour;

  @Column(name = "second_shift_start_hour", nullable = false)
  private Integer secondShiftStartHour;

  @Column(name = "second_shift_finish_hour", nullable = false)
  private Integer secondShiftFinishHour;

  @Column(name = "third_shift_start_hour", nullable = false)
  private Integer thirdShiftStartHour;

  @Column(name = "third_shift_finish_hour", nullable = false)
  private Integer thirdShiftFinishHour;

  @Column(name = "deliver_fee", nullable = false)
  private Float deliverFee;

  @Column(name = "cook_fee", nullable = false)
  private Float cookFee;

  @Column(name = "registration_pay_fee", nullable = false)
  private Long registrationPayFee;

  @Column(name = "herb_outstore_id", nullable = false)
  private Integer herbOutstoreId;

  @Column(name = "medicine_outstore_id", nullable = false)
  private Integer medicineOutstoreId;

  @Column(name = "reg_print", nullable = false)
  private Long regPrint;

  @Column(name = "record_print", nullable = false)
  private Long recordPrint;

  @Column(name = "prescription_print", nullable = false)
  private Long prescriptionPrint;

  @Column(name = "treatment_print", nullable = false)
  private Integer treatmentPrint;

  @Column(name = "combine_treatment_prescription", nullable = false)
  private Integer combineTreatmentPrescription;

  @Column(name = "pay_receipt_print", nullable = false)
  private Integer payReceiptPrint;

  @Column(name = "pay_prescription_print", nullable = false)
  private Integer payPrescriptionPrint;

  @Column(name = "clinic_level", nullable = false)
  private Integer clinicLevel;

  @Column(name = "clinic_type", nullable = false)
  private Integer clinicType;

  @Column(name = "single_member", nullable = false)
  private Integer singleMember;

  @Column(name = "default_pay_method", nullable = false)
  private Integer defaultPayMethod;

  @Column(name = "enable_sell", nullable = false)
  private Integer enableSell;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "last_receipt_code", nullable = false)
  private String lastReceiptCode;

  @Column(name = "avg_formula_price", nullable = false)
  private Float avgFormulaPrice;

  @Column(name = "receipt_type", nullable = false)
  private Integer receiptType;

  @Column(name = "designate_batch", nullable = false)
  private Integer designateBatch;

  @Column(name = "is_mn_exam", nullable = false)
  private Boolean mnExam;

  @Column(name = "is_multisite", nullable = false)
  private Boolean multisite;

  @Column(name = "is_advance_report", nullable = false)
  private Boolean advanceReport;

  @Column(name = "is_clinic_paid", nullable = false)
  private Boolean clinicPaid;

  @Column(name = "hw_setting", nullable = false)
  private String hwSetting;

  @Column(name = "clinic_flow", nullable = false)
  private String clinicFlow;

  @Column(name = "create_time")
  private Date createTime;

}
