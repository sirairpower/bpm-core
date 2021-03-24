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
@Table(name = "printer")
public class Printer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "clinic_id", nullable = false)
  private Integer clinicId;

  @Column(name = "pc_uuid", nullable = false)
  private String pcUuid;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "display_name", nullable = false)
  private String displayName;

}
