package com.bpm.service;

import com.bpm.dao.ShopeeProductInfoRepository;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ShopeeServiceImplTest {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ShopeeProductInfoRepository shopeeProductInfoRepository;

  @Value("${files.storage.path}")
  private String fileStoragePath;

  @Value("${java.io.tmpdir}")
  private String tmpdir;

  @Test
  void loadFileToLocal() throws IOException {
//    String tmpdir = System.getProperty("java.io.tmpdir");
//    FileUtils.forceMkdirParent(new File(fileStoragePath));
    shopeeProductInfoRepository.findAllById(Arrays.asList(206, 207, 208, 209, 210)).forEach(pi -> {
      logger.info("\nsub :{}", pi.getSubject());
      if (StringUtils.isNotBlank(pi.getImgLinks())) {
        try {
          File tmpdirProd = new File(tmpdir, pi.getId().toString());
          logger.info("tmpdirProd :{}", tmpdirProd.getAbsolutePath());
          FileUtils.forceMkdir(tmpdirProd);
          List<String> imgList = Arrays.asList(StringUtils.split(pi.getImgLinks(), ","));
          AtomicInteger imgCounter = new AtomicInteger(0);
          imgList.forEach(img -> {
            logger.info("img : {}", img);
            try {
              String imgName = String.valueOf(imgCounter.getAndAdd(1)).concat(".jpg");
              FileUtils.copyURLToFile(new URL(img), new File(tmpdirProd.getAbsolutePath(), imgName), 3000, 3000);
            } catch (IOException e) {
              logger.error(e.getMessage(), e);
            }
          });
          File realProd = new File(fileStoragePath, pi.getId().toString());
          FileUtils.forceMkdir(realProd);
          FileUtils.copyDirectory(tmpdirProd, realProd);
        } catch (IOException e) {
          logger.error(e.getMessage(), e);
        }

      }

    });

  }
}
