package com.tudi.yb.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YBMessage {
  private String type;
  private String action;
  private String instCode;
  private String transCode;
  private String data1;
  private String data2;
  private Integer no;
}
