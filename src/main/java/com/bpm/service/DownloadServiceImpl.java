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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DownloadServiceImpl implements DownloadService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ShopeeProductInfoRepository shopeeProductInfoRepository;

  @Value("${files.storage.path}")
  private String fileStoragePath;

  @Value("${java.io.tmpdir}")
  private String tmpdir;


  @Override
  public void loadFileToLocal() {
    shopeeProductInfoRepository.findAll().forEach(pi -> {
      logger.debug("\nsub :{}", pi.getSubject());
      if (StringUtils.isNotBlank(pi.getImgLinks())) {
        try {
          File tmpdirProd = new File(tmpdir, pi.getId().toString());
          logger.debug("tmpdirProd :{}", tmpdirProd.getAbsolutePath());
          FileUtils.forceMkdir(tmpdirProd);
          List<String> imgList = Arrays.asList(StringUtils.split(pi.getImgLinks(), ","));
          AtomicInteger imgCounter = new AtomicInteger(0);
          imgList.forEach(img -> {
            logger.debug("img : {}", img);
            try {
              String imgName = String.valueOf(imgCounter.getAndAdd(1)).concat(".jpg");
              FileUtils.copyURLToFile(new URL(img), new File(tmpdirProd.getAbsolutePath(), imgName), 3000, 3000);
            } catch (IOException e) {
              logger.error("", e);
            }
          });
          File realProd = new File(fileStoragePath, pi.getId().toString());
          FileUtils.forceMkdir(realProd);
          FileUtils.copyDirectory(tmpdirProd, realProd);
        } catch (IOException e) {
          logger.error("", e);
        }
      }
    });
  }
}
