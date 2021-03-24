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
@Table(name = "wx_message")
public class WxMessage implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "record_id", nullable = false)
  private Long recordId;

  @Column(name = "media_file", nullable = false)
  private String mediaFile;

  @Column(name = "message_type", nullable = false)
  private Integer messageType;

  @Column(name = "message_time", nullable = false)
  private Date messageTime;

  @Column(name = "sender", nullable = false)
  private Integer sender;

  @Column(name = "text_content", nullable = false)
  private String textContent;

}
