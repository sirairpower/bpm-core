package com.tudi.yb.dao;

import com.tudi.yb.model.WeixinQrcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WeixinQrcodeRepository extends JpaRepository<WeixinQrcode, Long>, JpaSpecificationExecutor<WeixinQrcode> {

}
