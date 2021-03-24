package com.tudi.yb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "template_mr")
public class TemplateMr implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "template_id", nullable = false)
  private Integer templateId;

  @Column(name = "name")
  private String name;

  @Column(name = "chief_complaint", nullable = false)
  private String chiefComplaint;

  @Column(name = "current_history", nullable = false)
  private String currentHistory;

  @Column(name = "tongue_pulse", nullable = false)
  private String tonguePulse;

  @Column(name = "symptom", nullable = false)
  private String symptom;

  @Column(name = "pattern_treatment", nullable = false)
  private String patternTreatment;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Column(name = "create_member", nullable = false)
  private Integer createMember;

  @Column(name = "update_time")
  private Date updateTime;

  @Column(name = "update_member")
  private Integer updateMember;

}
