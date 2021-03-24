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
@Table(name = "visit_msg")
public class VisitMsg implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "speaker", nullable = false)
  private Integer speaker;

  @Column(name = "content_type", nullable = false)
  private Integer contentType;

  @Column(name = "content")
  private String content;

  @Column(name = "modify_datetime", nullable = false)
  private Date modifyDatetime;

}
