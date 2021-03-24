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
@Table(name = "weixin_msg")
public class WeixinMsg implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "from_user", nullable = false)
  private String fromUser;

  @Column(name = "to_user", nullable = false)
  private String toUser;

  @Column(name = "create_time", nullable = false)
  private Long createTime;

  @Column(name = "msg_type", nullable = false)
  private String msgType;

  @Column(name = "msg_id")
  private Long msgId;

  @Column(name = "content")
  private String content;

}
