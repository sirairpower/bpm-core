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
@Table(name = "tudi_app_log")
public class TudiAppLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "log_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long logId;

  @Column(name = "uuid", nullable = false)
  private String uuid;

  @Column(name = "tudi_control_panel_version", nullable = false)
  private String tudiControlPanelVersion;

  @Column(name = "tudi_network_ip", nullable = false)
  private String tudiNetworkIp;

  @Column(name = "tudi_network_mask", nullable = false)
  private String tudiNetworkMask;

  @Column(name = "tudi_network_gateway", nullable = false)
  private String tudiNetworkGateway;

  @Column(name = "local_time", nullable = false)
  private Date localTime;

  @Column(name = "log_time", nullable = false)
  private Date logTime;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "clinic_config_json", nullable = false)
  private String clinicConfigJson;

}
