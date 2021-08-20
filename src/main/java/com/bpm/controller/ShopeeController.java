package com.bpm.controller;

import com.bpm.service.ShopeeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopeeController {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  ShopeeService shopeeService;

  @RequestMapping("/shopee/{mode}")
  public String shopeeBanbi(@PathVariable String mode) throws InterruptedException {
    logger.info("shopeeBanbi mode:{}", mode);
    if (StringUtils.equals(mode, "new")) {
      shopeeService.getBanbiSite();
    } else if (StringUtils.equals(mode, "tidyData")) {
      shopeeService.tidyData();
    }
    return "Completed well show on page ~ ";
  }

  public static void main(String... args) throws Exception {

  }

}
