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
@Accessors(chain = true)
@Table(name = "wxpay_store")
public class WxpayStore implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "clinic_id", nullable = false)
  private Long clinicId;

  @Column(name = "store_id", nullable = false)
  private String storeId;

  @Column(name = "sub_store_id", nullable = false)
  private String subStoreId;

  @Column(name = "pay_key", nullable = false)
  private String payKey;

  @Column(name = "cert_file", nullable = false)
  private String certFile;

  @Column(name = "name", nullable = false)
  private String name;

}
