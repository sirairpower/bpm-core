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
@Table(name = "out_log")
@Accessors(chain = true)
public class OutLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "type", nullable = false)
  private Integer type;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

  @Column(name = "response_time")
  private Date responseTime;

  @Column(name = "input", nullable = false)
  private String input;

  @Column(name = "output", nullable = false)
  private String output;

}
