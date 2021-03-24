package com.tudi.yb.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(
    locations = "classpath:application-dev.properties")
class ClinicRepositoryTest {


  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  ClinicRepository dao;

  @Test
  public void testSelectAll(){
    logger.info("testSelectAll start");
    logger.info("size : {}",dao.findAll().size());
    dao.findAll().forEach(c->{
      logger.info("size : {}", ToStringBuilder.reflectionToString(c,ToStringStyle.SIMPLE_STYLE));

    });
  }
}
