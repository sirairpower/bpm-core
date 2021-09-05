package com.bpm.service;

import com.bpm.dao.ShopeeProductInfoRepository;
import com.bpm.model.ShopeeProductInfo;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

  @Value("${files.task.name}")
  private String filesTaskName;

  @Value("${java.io.tmpdir}")
  private String tmpdir;


  @Override
  public void loadFileToLocal() {
    try {
      File tmpdirProd = new File(tmpdir + filesTaskName);
      logger.debug("tmpdirProd :{}", tmpdirProd.getAbsolutePath());
      FileUtils.forceMkdir(tmpdirProd);
      File realProd = new File(fileStoragePath + filesTaskName);
      logger.debug("realProd :{}", realProd.getAbsolutePath());
      FileUtils.forceMkdir(realProd);
      List<ShopeeProductInfo> prods = shopeeProductInfoRepository.fetchAllWithVariantion();
      prods.forEach(prod -> {
        //get product img
        if (StringUtils.isNotBlank(prod.getImgLinks())) {
          List<String> prodImgsOfShopee = Arrays.asList(StringUtils.split(prod.getImgLinks(), ","));
          List<String> prodImgs = new ArrayList<>();
          AtomicInteger imgCounter = new AtomicInteger(0);
          logger.debug("\nsub :{}", prod.getSubject());
          prodImgsOfShopee.forEach(img -> {
            logger.debug("p-img : {}", img);
            try {
              String imgName = "p" + prod.getId() + "_" + String.valueOf(imgCounter.getAndAdd(1)).concat(".jpg");
              FileUtils.copyURLToFile(new URL(img), new File(tmpdirProd.getAbsolutePath(), imgName), 3000, 3000);
              prodImgs.add(imgName);
            } catch (IOException e) {
              logger.error(e.getMessage(), e);
            }
          });
          prod.setImgLinks(String.join(",", prodImgs));
        }
        //get variant product img
        prod.getShopeeVariantProds().forEach(vp -> {
          if (StringUtils.isNotBlank(vp.getVariantImg())) {
            try {
              String vImgName = "v" + vp.getId() + ".jpg";
              FileUtils.copyURLToFile(new URL(vp.getVariantImg()), new File(tmpdirProd.getAbsolutePath(), vImgName), 3000, 3000);
              vp.setVariantImg(vImgName);
            } catch (IOException e) {
              logger.error(e.getMessage(), e);
            }
          }
        });
      });
      shopeeProductInfoRepository.saveAll(prods);

      FileUtils.copyDirectory(tmpdirProd, realProd);
    } catch (IOException e) {
      logger.error("", e);
    }
  }

  @Override
  public String getFilePathAbsolute(String fileName) {
    File file = new File(fileStoragePath + filesTaskName + File.separator + fileName);
    return file.isFile() ? file.getAbsolutePath() : "";
  }
  
}
