package com.bpm.service;

import com.bpm.dao.ShopeeProductInfoRepository;
import com.bpm.model.ShopeeProductInfo;
import com.bpm.model.ShopeeVariantProd;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WPBambiServiceImpl extends BaseService implements WPBambiService {

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
  private ShopeeProductInfoRepository productInfoRepository;

  @Override
  public void inputProdToBambi() {
    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--headless");
//    options.addArguments("--disable-gpu");
    options.setCapability("excludeSwitches", Arrays.asList("disable-popup-blocking"));
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    try {
      //into wp-admin
      loginToAdmin(driver);

      List<ShopeeProductInfo> prods = productInfoRepository.fetchAllWithVariantion();
      //establish category
//      extablishCategory(driver, prods);

      //add new prod
      toPublish(driver, prods, -1, -1);

      Thread.sleep(5000);
    } catch (InterruptedException ex) {
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
    toIdx = (toIdx == -1) ? prods.size() : toIdx;
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
        }
      });
    });
  }

  private void setupNewProd(WebDriver driver, ShopeeProductInfo prod, ShopeeVariantProd vari, AtomicBoolean needDraft) {
    driver.get(URL_WP_ADMIN + URI_ADD_PROD);
    new WebDriverWait(driver, 100L).until(ExpectedConditions.elementToBeClickable(By.id("publish")));
    //set category
    List<WebElement> cates = driver.findElements(By.className("selectit"));
    cates.stream().filter(cat -> StringUtils.equals(cat.getText(), prod.getCategoryName())).findFirst().get().click();
    //set prod name
    WebElement title = driver.findElement(By.id("title"));
    title.sendKeys(prod.getSubject());
    //set short description from prod.desc
    WebElement iframe = driver.findElement(By.id("excerpt_ifr"));
    driver.switchTo().frame(iframe);
    WebElement prodShortDesc = driver.findElement(By.id("tinymce"));
    prodShortDesc.sendKeys(prod.getDescription());
    driver.switchTo().defaultContent();
    //set regular price (if null then 0)
    WebElement element = new WebDriverWait(driver, 30L).until(ExpectedConditions.elementToBeClickable(By.id("woocommerce-product-data")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    waitForJSandJQueryToLoad(driver);
    if (null != vari.getPrice()) {
      driver.findElement(By.name("_regular_price")).sendKeys(vari.getPrice().toString());
    } else {
      waitForJSandJQueryToLoad(driver);
      callThreadSleep(500);
      clickByCssName(driver, "inventory_options");
      waitForJSandJQueryToLoad(driver);
      WebElement parent = driver.findElement(By.id("_stock_status"));
      Select parentSelect = new Select(parent);
      parentSelect.selectByVisibleText("Out of stock");
      needDraft = new AtomicBoolean(true);
    }
    //set SKU
    waitForJSandJQueryToLoad(driver);
    callThreadSleep(500);
    clickByCssName(driver, "inventory_options");
    waitForJSandJQueryToLoad(driver);
    driver.findElement(By.name("_sku")).sendKeys(formatSKU(prod.getId(), vari.getId()));
    //set attribute from vari.desc
    if (prod.getVariantProdTrue()) {
      clickByCssName(driver, "attribute_options");
      waitForJSandJQueryToLoad(driver);
      clickByCssName(driver, "add_attribute");
      waitForJSandJQueryToLoad(driver);
      driver.findElement(By.name("attribute_names[0]")).sendKeys("sub-title");
      driver.findElement(By.name("attribute_values[0]")).sendKeys(vari.getDescription());
      callThreadSleep(500);
      driver.findElement(By.className("save_attributes")).click();
      waitForJSandJQueryToLoad(driver);
    }
    //set img
    setImg(driver, prod, vari);
    callThreadSleep(500);
    WebElement toAction = null;
    if (needDraft.get()) {
      toAction = driver.findElement(By.id("save-post"));
      logger.debug("draft:{}", vari.getId());
    } else {
      toAction = driver.findElement(By.id("publish"));
      logger.debug("publish:{}", vari.getId());
    }
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toAction);
  }

  private void clickByCssName(WebDriver driver, String cssName) {
    new WebDriverWait(driver, 30L).until(ExpectedConditions.elementToBeClickable(By.className(cssName))).click();
    waitForJSandJQueryToLoad(driver);
  }

  private void setImg(WebDriver driver, ShopeeProductInfo prod, ShopeeVariantProd vari) {
    driver.findElement(By.id("set-post-thumbnail")).click();
    waitForJSandJQueryToLoad(driver);
    //menu-item-browse
    driver.findElement(By.id("menu-item-browse")).click();
    waitForJSandJQueryToLoad(driver);
    callThreadSleep(1000);
    //media-search-input
    String imgName = "";
    if (prod.getVariantProdTrue()) {
      imgName = vari.getVariantImg();
    } else {
      imgName = prod.getImgLinks().split(",")[0];
    }
    driver.findElement(By.id("media-search-input")).sendKeys(imgName);
    waitForJSandJQueryToLoad(driver);
    callThreadSleep(1000);
    List<WebElement> thumbnails = driver.findElement(By.className("attachments-wrapper")).findElements(By.className("thumbnail"));
    logger.debug("thumbnails:{}", thumbnails.size());
    if (thumbnails.size() > 0) {
      thumbnails.get(0).click();
      driver.findElement(By.className("media-button")).click();
      waitForJSandJQueryToLoad(driver);
    }
  }

  private String formatSKU(Integer prodId, Integer variId) {
    return (prodId != 0 && variId != 0) ? String.format(SKU_FORMAT, prodId, variId) : "";
  }

  private void extablishCategory(WebDriver driver, List<ShopeeProductInfo> prods) {
    driver.get(URL_WP_ADMIN + URI_CATEGORY);
    new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("search-submit")));
    Set<String> categoryNames = prods.stream().map(ShopeeProductInfo::getCategoryName).collect(Collectors.toSet());
    categoryNames.forEach(cName -> {
      logger.debug("cName:{}", cName);
      WebElement tagSearchInput = driver.findElement(By.id("tag-search-input"));
      tagSearchInput.clear();
      tagSearchInput.sendKeys(StringEscapeUtils.escapeHtml4(cName));
      WebElement searchCategoryBtn = new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("search-submit")));
      searchCategoryBtn.click();
      new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("search-submit")));
      WebElement theList = driver.findElement(By.id("the-list"));
      if (!theList.findElements(By.className("no-items")).isEmpty()) {
        WebElement tagName = driver.findElement(By.id("tag-name"));
        tagName.sendKeys(cName);
        WebElement parent = driver.findElement(By.id("parent"));
        Select parentSelect = new Select(parent);
        parentSelect.selectByVisibleText("品牌館");
        WebElement addNewCategorySubmit = driver.findElement(By.id("submit"));
        addNewCategorySubmit.click();
        new WebDriverWait(driver, 10L).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("the-list")), cName));
        logger.info("add a new category named : {}", cName);
      }
    });
  }
}
