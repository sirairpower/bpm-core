package com.tudi.yb.model;

import com.tudi.yb.model.TemplateMedicine.TemplateMedicinePK;
import java.io.Serializable;
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
@Table(name = "template_medicine")
@IdClass(TemplateMedicinePK.class)
public class TemplateMedicine implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class TemplateMedicinePK implements  Serializable{
    private Long templateId;
    private Long serialNumber;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "template_id", nullable = false)
  private Long templateId;

  @Id
  @Column(name = "serial_number", nullable = false)
  private Long serialNumber;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "package_specification", nullable = false)
  private String packageSpecification;

  @Column(name = "package_unit", nullable = false)
  private String packageUnit;

  @Column(name = "min_unit", nullable = false)
  private String minUnit;

  @Column(name = "package_count", nullable = false)
  private Integer packageCount;

  @Column(name = "out_unit", nullable = false)
  private Integer outUnit;

  @Column(name = "out_count", nullable = false)
  private Float outCount;

  @Column(name = "menu_freq_id", nullable = false)
  private Long menuFreqId;

  @Column(name = "menu_usage_id", nullable = false)
  private Long menuUsageId;

  @Column(name = "times_of_day", nullable = false)
  private Integer timesOfDay;

  @Column(name = "dose", nullable = false)
  private String dose;

  @Column(name = "days", nullable = false)
  private Integer days;

  @Column(name = "group_num", nullable = false)
  private Integer groupNum;

}
