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
@Table(name = "kb_formula")
public class KbFormula implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "chinese", nullable = false)
  private String chinese;

  @Column(name = "english", nullable = false)
  private String english;

  @Column(name = "source_id", nullable = false)
  private Integer sourceId;

  @Column(name = "category_id", nullable = false)
  private Long categoryId;

  @Column(name = "code", nullable = false)
  private String code;

  @Column(name = "usage_id")
  private Long usageId;

  @Column(name = "mod_date", nullable = false)
  private Date modDate;

  @Column(name = "remark")
  private String remark;

}
