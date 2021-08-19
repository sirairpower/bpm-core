package com.bpm.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ShopeeServiceImplTest {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private DownloadService downloadService;

  @Test
  void getContentType() throws IOException {
    URL url = new URL("https://cf.shopee.tw/file/1306fc0f2a2cb711fe1559353ed9e055");
    URLConnection conn = url.openConnection();
    String contentType = conn.getContentType();
    logger.info("contentType:{}", contentType);
  }

  @Test
  void loadFileToLocal() throws IOException {
//    String tmpdir = System.getProperty("java.io.tmpdir");
//    FileUtils.forceMkdirParent(new File(fileStoragePath));
    downloadService.loadFileToLocal();
  }

}
