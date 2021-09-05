package com.bpm.service;

import com.bpm.dao.ShopeeProductInfoRepository;
import com.bpm.model.ShopeeProductInfo;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WPBambiServiceImplTest extends BaseService {

  Logger logger = LoggerFactory.getLogger(this.getClass());
  String URL_WP_ADMIN = "https://kokomi.vip/wp-admin";
  String URL_KOKOMI = "https://kokomi.vip/my-account";
  String URI_CATEGORY = "/edit-tags.php?taxonomy=product_cat&post_type=product";
  String URI_ALL_PROD = "/edit.php?post_type=product";
  String URI_ADD_PROD = "/post-new.php?post_type=product";
  String user = "howard_chang@bpm.tw";
  String password = "tIcte0-vabhum-bojjaw";
  String SKU_FORMAT = "P%dV%d";

  @Autowired
  private WPBambiService wpBambiService;
  @Autowired
  private ShopeeProductInfoRepository productInfoRepository;

  @BeforeAll
  static void setupAllAtOnce() {
    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
  }

  @Test
  void inputProdToBambi() {
    wpBambiService.inputProdToBambi();
  }

  @Test
  void testLoginAdmin() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.manage().window().maximize();

      loginToAdmin(driver);

      List<ShopeeProductInfo> prods = productInfoRepository.fetchAllWithVariantion();

      //add new prod
      toPublish(driver, prods, 0, -1);
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    } finally {
      driver.close();
      driver.quit();
    }
  }

  private void loginToAdmin(WebDriver driver) {
    driver.get(URL_KOKOMI);
    WebElement login = new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.name("login")));
    WebElement userLogin = driver.findElement(By.id("username"));
    WebElement userPass = driver.findElement(By.id("password"));
    userLogin.clear();
    userLogin.sendKeys(user);
    userPass.clear();
    userPass.sendKeys(password);
    login.click();
    new WebDriverWait(driver, 30L).until(ExpectedConditions.textToBe(By.className("display-name"), "Howard Chang"));
    logger.info("{} login wp-admin succeed!", user);
    driver.get(URL_WP_ADMIN + URI_ALL_PROD);
  }


  private void toPublish(WebDriver driver, List<ShopeeProductInfo> prods, int fromIdx, int toIdx) {
    fromIdx = (fromIdx == -1) ? 0 : fromIdx;
    toIdx = (toIdx == -1) ? prods.size() : (toIdx > prods.size()) ? prods.size() : toIdx;
    prods = prods.subList(fromIdx, toIdx);
    prods.forEach(prod -> {
      logger.debug("prod id:{}", prod.getId());
      prod.getShopeeVariantProds().forEach(vari -> {
        AtomicBoolean needDraft = new AtomicBoolean(false);
        if (!StringUtils.contains(driver.getCurrentUrl(), URI_ALL_PROD)) {
          driver.get(URL_WP_ADMIN + URI_ALL_PROD);
        }
        WebElement theList = driver.findElement(By.id("the-list"));
        //List contain item(s)
        //check if exist prod
        if (theList.findElements(By.className("no-items")).isEmpty()) {
          WebElement postSearchInput = driver.findElement(By.id("post-search-input"));
          postSearchInput.clear();
          postSearchInput.sendKeys(formatSKU(prod.getId(), vari.getId()));
          driver.findElement(By.id("search-submit")).click();
          new WebDriverWait(driver, 100L).until(ExpectedConditions.elementToBeClickable(By.id("search-submit")));
          theList = driver.findElement(By.id("the-list"));
        }
        logger.debug("variant id:{}", vari.getId());
        //prod not exist in WP yet
        if (!theList.findElements(By.className("no-items")).isEmpty()) {
          logger.debug("Not found ~");
//          setupNewProd(driver, prod, vari, needDraft);
        } else {
          logger.debug("found sku:{}", formatSKU(prod.getId(), vari.getId()));
          List<WebElement> rowTitles = theList.findElements(By.className("row-title"));
          Optional<WebElement> op = rowTitles.stream().filter(rt -> (StringUtils.equals(rt.getText(), prod.getSubject()))).findFirst();
          if (op.isPresent()) {
            WebElement prodLink = op.get();
            logger.debug("{} link : {}", prodLink.getText(), prodLink.getAttribute("href"));
            prodLink.click();
            WebElement editSlug = new WebDriverWait(driver, 100L).until(ExpectedConditions.elementToBeClickable(By.className("edit-slug")));
            editSlug.click();
            WebElement postSlugInput = new WebDriverWait(driver, 10L).until(ExpectedConditions.presenceOfElementLocated(By.id("new-post-slug")));
            if (!StringUtils.equals(postSlugInput.getAttribute("value"), formatSKU(prod.getId(), vari.getId()))) {
              postSlugInput.clear();
              postSlugInput.sendKeys(formatSKU(prod.getId(), vari.getId()));
              logger.debug("slug:{}", postSlugInput.getAttribute("value"));
              WebElement okBtn = new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"OK\"]")));
              okBtn.click();
              WebElement publish = new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("publish")));
              publish.click();
              callThreadSleep(800);
            }
          }
        }
      });
    });
  }

  private String formatSKU(Integer prodId, Integer variId) {
    return (prodId != 0 && variId != 0) ? String.format(SKU_FORMAT, prodId, variId) : "";
  }

}
