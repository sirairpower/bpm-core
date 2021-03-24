package com.tudi.yb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "menu")
@Accessors(chain = true)
public class Menu implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "menu_type", nullable = false)
  private Long menuType;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "ins_id", nullable = false)
  private String insId;

}
