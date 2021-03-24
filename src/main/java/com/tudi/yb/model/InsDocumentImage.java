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
@Table(name = "ins_document_image")
public class InsDocumentImage implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "platform_id", nullable = false)
  private String platformId;

  @Column(name = "image_id", nullable = false)
  private String imageId;

  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "create_time", nullable = false)
  private Date createTime;

}
