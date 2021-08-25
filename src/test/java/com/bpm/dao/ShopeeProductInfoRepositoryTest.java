package com.bpm.dao;

import com.bpm.model.ShopeeProductInfo;
import com.bpm.model.ShopeeVariantProd;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@Transactional
class ShopeeProductInfoRepositoryTest {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ShopeeProductInfoRepository shopeeProductInfoRepository;

  @Autowired
  private ShopeeVariantProdRepository shopeeVariantProdRepository;

  @BeforeEach
  void setUp() {
  }
  
  @Test
  void fetchAllWithVariantion() {
    shopeeProductInfoRepository.fetchAllWithVariantion().forEach(prod -> {
      logger.debug("prod id:{}", prod.getId());
      if (prod.getVariantProdTrue()) {
        prod.getShopeeVariantProds().forEach(pv -> {
          logger.debug("variant id:{}", pv.getId());
        });
      }
    });
  }

  @Test
//  @Rollback
  void injectedComponentsAreNotNull() {
    Assertions.assertThat(shopeeProductInfoRepository).isNotNull();
    ShopeeProductInfo productInfo = new ShopeeProductInfo();
    productInfo.setCategoryName("test category name");
    productInfo.setSubject("test subject");
    productInfo.setLink("test link");
    productInfo.setVariantProdTrue(false);
    productInfo.setImgLinks("test img link,link1,");
    productInfo.setDescription("test test desc desc");
    productInfo.setCreateUser("Howard");
    productInfo.setCreateDate(new Date());

    ShopeeVariantProd variantProd = new ShopeeVariantProd();
    variantProd.setPrice(5);
    variantProd.setDescription("test description");
    variantProd.setSoldOut(false);
    variantProd.setShopeeProductInfo(productInfo);
    List<ShopeeVariantProd> variantProdList = new ArrayList<>();
    variantProdList.add(variantProd);
    productInfo.setShopeeVariantProds(variantProdList);
    shopeeProductInfoRepository.save(productInfo);
    logger.info("size:{},{}", shopeeProductInfoRepository.findAll().size(), shopeeVariantProdRepository.findAll().size());

  }
}
