package com.bpm.service;

import com.bpm.dao.ShopeeProductInfoRepository;
import com.bpm.model.ShopeeProductInfo;
import com.bpm.model.ShopeeVariantProd;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ShopeeServiceImpl extends BaseService implements ShopeeService {

  private static final String ALL_CAT = "所有商品";
  private String currentCategoryName;
  private Map<String, ShopeeProductInfo> allProds;
  private Date now;
  private String user;

  @Autowired
  private ShopeeProductInfoRepository productInfoRepository;

  @Override
  public void getBanbiSite() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    try {
      logger.info("Collect data from shopee banbi.");
      Map<String, Set<ShopeeProductInfo>> allCategoryProdInfo = getAllCategoryProdInfo(driver);
      logger.info("Write data to db.");
      allCategoryProdInfo.forEach((k, v) -> {
        logger.info("category:{},size:{}", k, v.size());
        productInfoRepository.saveAll(v);
      });
      logger.info("Completed well ~");
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      driver.quit();
    }
  }

  @Override
  public void tidyData() {
    productInfoRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).forEach(prod -> {
      String tidySubject = prod.getSubject();
      logger.debug("id , subject :{}", prod.getId(), tidySubject);


    });
  }

  private Map<String, Set<ShopeeProductInfo>> getAllCategoryProdInfo(WebDriver driver) {
    currentCategoryName = "";
    allProds = null;
    now = null;
    user = "";
    driver.navigate().to("https://shopee.tw/shop/2901888/search");
    logger.info("In page : {}", driver.getTitle());
    callThreadSleep(5000);
    List<WebElement> elements = driver.findElements(By.className("shopee-shop-collection-filter__collection"));
    logger.info("Get main categories and it's size : {}", elements.size());
    return runAllCategory(driver, elements);
  }

  private Map<String, Set<ShopeeProductInfo>> runAllCategory(WebDriver driver, List<WebElement> elements) {
    Map<String, Set<ShopeeProductInfo>> allCategoryProdInfo = new HashMap<>();
    now = new Date();
    user = "Howard";
    elements.forEach(e -> {
      currentCategoryName = StringUtils.trim(e.getText());
      logger.info("Category name : {}", currentCategoryName);
      e.click();
      //ERROR stale element reference: element is not attached to the page document.
      //So this block just imperative the time wait 5 sec.
      callThreadSleep(5000);
      if (waitForJSandJQueryToLoad(driver)) {
        if (StringUtils.equals(currentCategoryName, ALL_CAT)) {
          allProds = runAllPage(driver).stream().collect(Collectors.toMap(p -> p.getSubject(), Function.identity()));
        } else {
          allCategoryProdInfo.put(currentCategoryName, runAllPage(driver));
        }
      }
    });
    allCategoryProdInfo.put(ALL_CAT, new HashSet<>(allProds.values()));
    return allCategoryProdInfo;
  }


  private Set<ShopeeProductInfo> runAllPage(WebDriver driver) {
    //Into category page. Get page num and product link.
    WebElement currentPage = driver.findElement(By.className("shopee-mini-page-controller__current"));
    WebElement totalPage = driver.findElement(By.className("shopee-mini-page-controller__total"));
    int currentPageNum = Integer.parseInt(currentPage.getText());
    int totalPageNum = Integer.parseInt(totalPage.getText());
    Set<ShopeeProductInfo> productInfos = new HashSet<>();
    logger.info("Page current:{},total:{}", currentPage.getText(), totalPage.getText());
    for (; currentPageNum <= totalPageNum; currentPageNum++) {
      runAllProd(driver, productInfos);
      //if has next , click it.
      WebElement next = driver.findElement(By.className("shopee-mini-page-controller__next-btn"));
      logger.debug("IsNextAvailable:{}", next.isEnabled());
      if (next.isEnabled()) {
        next.click();
      }
    }
    logger.info("Category {} : {} piece.", currentCategoryName, productInfos.size());
    return productInfos;
  }

  private void runAllProd(WebDriver driver, Set<ShopeeProductInfo> productInfos) {
    List<WebElement> elementsOfProd = new WebDriverWait(driver, 5L)
        .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("shop-search-result-view__item"), 0));

    if (StringUtils.equals(currentCategoryName, ALL_CAT)) {
      elementsOfProd.forEach(ep -> {
        WebElement aHref = ep.findElement(By.tagName("a"));
        String href = aHref.getAttribute("href");
        logger.debug("Prod link : {}", href);
        final String subject = StringUtils.trim(ep.findElement(By.cssSelector("div[data-sqe='name']")).getText());
        logger.debug("subject : {}", subject);
        productInfos.add(openProdPage(driver, href, subject));
      });
    } else {
      elementsOfProd.forEach(ep -> {
        final String subject = StringUtils.trim(ep.findElement(By.cssSelector("div[data-sqe='name']")).getText());
        logger.debug("Prod subject : {}", subject);
        ShopeeProductInfo productInfo = allProds.remove(subject);
        if (null != productInfo) {
          productInfo.setCategoryName(currentCategoryName);
          productInfos.add(productInfo);
        } else {
          logger.info("Not Found : {}", subject);
        }
      });
    }
  }

  private ShopeeProductInfo openProdPage(WebDriver driver, String href, String subject) {
    //Open new tab
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1)); //switches to new tab
    driver.get(href);
    ShopeeProductInfo productInfo = new ShopeeProductInfo();
    productInfo.setCategoryName(currentCategoryName);
    productInfo.setLink(href);
    WebElement primaryBtn = new WebDriverWait(driver, 5L)
        .until(ExpectedConditions.elementToBeClickable(By.className("btn-solid-primary")));
    WebElement selectionDiv = new WebDriverWait(driver, 60L)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div")));

    //final String subject = StringUtils.trim(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div[1]/span")).getText());
    productInfo.setSubject(subject);
    List<String> prodImgs = getProdImgs(driver, productInfo);
    makeVariantOfProd(driver, productInfo, selectionDiv, prodImgs);
    productInfo.setImgLinks(StringUtils.join(prodImgs, ","));
//    productInfo.setInventoryQuantity();
    final String desc = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div/span")).getText();
    productInfo.setDesc(desc);
    productInfo.setCreateDate(now);
    productInfo.setCreateUser(user);
    logger.debug("\nproductInfo:\n{}", productInfo);
    driver.close();
    driver.switchTo().window(tabs.get(0));
    callThreadSleep(1000);
    return productInfo;
  }

  private List<String> getProdImgs(WebDriver driver, ShopeeProductInfo productInfo) {
    List<WebElement> miniPhotosDiv = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div"));
    Actions builder = new Actions(driver);
    List<String> imgs = new ArrayList<>();
    miniPhotosDiv.forEach(ph -> {
      builder.moveToElement(ph).perform();
      String backgroundImage = getBackgroundImgOfLeftSide(driver, ph);
      if (StringUtils.isNotBlank(backgroundImage)) {
        imgs.add(backgroundImage);
      }
    });
    return imgs;
  }

  private String getBackgroundImgOfLeftSide(WebDriver driver, WebElement ph) {
    WebElement photoDiv = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div")));
    String backgroundImage = "";
    if (waitForJSandJQueryToLoad(driver)) {
      backgroundImage = photoDiv.getCssValue("background-image");
    }
    if (StringUtils.isNotBlank(backgroundImage)) {
      backgroundImage = StringUtils.remove(backgroundImage, "url(\"");
      backgroundImage = StringUtils.remove(backgroundImage, "\")");
    } else {
      logger.warn("Miss backgroundImage:{}", ph.getText());
    }
    return backgroundImage;
  }

  private void makeVariantOfProd(WebDriver driver, ShopeeProductInfo productInfo, WebElement selectionDiv, List<String> prodImgs) {
    WebElement choiceArea = null;
    List<WebElement> choiceBtns = selectionDiv.findElements(By.className("product-variation"));

    logger.info("choiceBtns.size:{}", choiceBtns.size());
    if (choiceBtns.size() > 1) {
      productInfo.setVariantProdTrue(true);
      Actions hover = new Actions(driver);
      choiceBtns.forEach(btn -> {
        ShopeeVariantProd variantProd = new ShopeeVariantProd();
        hover.moveToElement(btn).build().perform();
        String backgroundImage = getBackgroundImgOfLeftSide(driver, btn);
        if (StringUtils.isNotBlank(backgroundImage)) {
          prodImgs.removeIf(img -> StringUtils.equals(img, backgroundImage));
          variantProd.setVariantImg(backgroundImage);
        }
        if (StringUtils.contains(btn.getAttribute("class"), "product-variation--disabled")) {
          variantProd.setDescription(btn.getText());
        } else {
          List<WebElement> ticks = btn.findElements(By.className("product-variation__tick"));
          if (ticks.size() == 0) {
            btn.click();
          }
          WebElement tickDiv = new WebDriverWait(driver, 3L).until(ExpectedConditions.presenceOfElementLocated(By.className("product-variation__tick")));
          variantProd.setPrice(getPrice(driver));
          variantProd.setDescription(btn.getText());
        }
        logger.debug("price:{},desc:{}", variantProd.getPrice(), variantProd.getDescription());
        variantProd.setShopeeProductInfo(productInfo);
        addOneVariantProd(productInfo, variantProd);
      });
    } else {
      productInfo.setVariantProdTrue(false);
      ShopeeVariantProd variantProd = new ShopeeVariantProd();
      variantProd.setPrice(getPrice(driver));
      variantProd.setShopeeProductInfo(productInfo);
      addOneVariantProd(productInfo, variantProd);
    }
  }

  private int getPrice(WebDriver driver) {
    String priceText = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div/div/div/div/div")).getText();
    priceText = StringUtils.remove(priceText, "$");
    priceText = StringUtils.remove(priceText, ",");
    return NumberUtils.toInt(priceText, 0);
  }

  public void addOneVariantProd(ShopeeProductInfo productInfo, ShopeeVariantProd variantProd) {
    if (null == productInfo.getShopeeVariantProds()) {
      productInfo.setShopeeVariantProds(new ArrayList<>());
    }
    productInfo.getShopeeVariantProds().add(variantProd);
  }

}

