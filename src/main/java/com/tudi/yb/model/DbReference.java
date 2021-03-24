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
@Table(name = "db_reference")
public class DbReference implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ID;

  @Column(name = "item_id", nullable = false)
  private Integer itemId;

  @Column(name = "item_type_id", nullable = false)
  private Integer itemTypeId;

  @Column(name = "ref_id", nullable = false)
  private Integer refId;

  @Column(name = "ref_type_id", nullable = false)
  private Integer refTypeId;

  @Column(name = "importance", nullable = false)
  private Integer importance;

  @Column(name = "ref_source", nullable = false)
  private String refSource;

}
