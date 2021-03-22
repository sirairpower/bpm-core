package com.tudi.yb.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicIns {

  private int clinicId; //診所編號
  private int insType; //醫保類型，1 = 杭州市醫保, 2 = 浙江省醫保, 3 = 浙江省異地, 4 = 台州市醫保, 5 = 台州溫嶺醫保
  private String clinicInsId; //醫療機構編號
  private String operatorId; //操作員編號, 診所申請醫保會得到的操作員編號
  private String operatorName; //操作員姓名, 診所申請醫保的操作員姓名
  private String operatorSerial; //业务周期号, 診所操作員每次簽到會得到的序號
  private String operatorSerialTime; //業務週期號產生時間，yyyy/MM/dd HH:mm:ss
  private String enableTime; //醫保正式啟用時間
  private String areaCode; //地區號，台州市331002椒江，331003黃岩，331004路橋
  private String insIp; //醫保中心分配IP
  private String wnStockId; //網能庫房編碼
  private String majorMachineIp; //前置機IP

}
