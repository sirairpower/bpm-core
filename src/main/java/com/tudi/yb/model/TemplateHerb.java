package com.tudi.yb.model;

import com.tudi.yb.model.OutMedicineHistory.OutMedicineHistoryPK;
import com.tudi.yb.model.TemplateHerb.TemplateHerbPK;
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
@Table(name = "template_herb")
@IdClass(TemplateHerbPK.class)
public class TemplateHerb implements Serializable {

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class TemplateHerbPK implements  Serializable{
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

  @Column(name = "unit", nullable = false)
  private String unit;

  @Column(name = "out_count", nullable = false)
  private Float outCount;

  @Column(name = "menu_cooktype_id", nullable = false)
  private Long menuCooktypeId;

}
