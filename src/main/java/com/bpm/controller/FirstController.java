package com.bpm.controller;

import com.bpm.service.ShopeeService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO - Take off .Just for poc.
@RestController
public class FirstController {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  ShopeeService shopeeService;

  @RequestMapping("/shopee/{mode}")
  public String shopeeBanbi(@PathVariable String mode) throws InterruptedException {
    logger.info("shopeeBanbi mode:{}", mode);
    if (StringUtils.equals(mode, "new")) {
      shopeeService.getBanbiSite();
    }

    return "Completed well show on page ~ ";
  }

  private WebDriver testActiveAttr() {
    WebDriver driver;
    driver = new ChromeDriver();
    driver.get("http://www.google.com");
    driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

    // Get attribute of current active element
    String attr = driver.switchTo().activeElement().getAttribute("title");
    logger.info("attr:{}", attr);
    return driver;
  }


  public static void main(String... args) throws Exception {
    Logger logger = LoggerFactory.getLogger(FirstController.class);
//    getPhotos(logger, driver);
//    getSubject(logger);
    String link = "url(\"https://cf.shopee.tw/file/dcce61d0a75bce68143a3f614fa5d06b\")";
    link = StringUtils.remove(link, "url(\"");
    link = StringUtils.remove(link, "\")");
    logger.info("plant link : {}", link);

  }

  private static void getSubject(Logger logger) {

    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
    WebDriver driver = new ChromeDriver();
    try {
      driver.manage().window().maximize();
      driver.get("https://shopee.tw/shop/2901888/search?page=0&shopCollection=182877");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException ex) {
        logger.error(ex.getMessage(), ex);
      }
      List<WebElement> elementsOfProd = new WebDriverWait(driver, 5L)
          .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("shop-search-result-view__item"), 0));
      logger.info("size : {}", elementsOfProd.size());
      elementsOfProd.forEach(item -> {
        logger.info("{}", item.findElement(By.cssSelector("div[data-sqe='name']")).getText());
      });
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    } finally {
      driver.close();
      driver.quit();
    }
  }

  private static void getPhotos(Logger logger, WebDriver driver) {
    driver.get("https://shopee.tw/(%E9%99%90%E9%87%8F%E5%A2%9E%E9%87%8F%E7%89%88%E6%90%B6%E8%B3%BC)-%E5%A8%9C%E8%8A%99-NOV-%E9%98%B2%E6%9B%AC%E6%B0%B4%E5%87%9D%E4%B9%B3-35g-46g%E5%A2%9E%E9%87%8F%E7%89%88-SPF32-(%E5%85%AC%E5%8F%B8%E8%B2%A8)-%E5%AF%B6%E5%AF%B6%E5%8F%AF%E7%94%A8.%E6%BA%AB%E6%B0%B4%E5%8D%B8%E9%99%A4.-i.2901888.30667268?position=0");
    WebElement primaryBtn = new WebDriverWait(driver, 5L)
        .until(ExpectedConditions.elementToBeClickable(By.className("btn-solid-primary")));
    WebElement selectionDiv = new WebDriverWait(driver, 5L)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div/div[4]/div")));
    List<WebElement> miniPhotosDiv = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div"));
    Actions builder = new Actions(driver);
    miniPhotosDiv.forEach(ph -> {
      builder.moveToElement(ph).perform();
      WebElement photoDiv = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div"));
      String backgroundImage = photoDiv.getCssValue("background-image");
      logger.info("backgroundImage:{}", backgroundImage);
      try {
        Thread.sleep(500);
      } catch (InterruptedException ex) {
        logger.error(ex.getMessage(), ex);
      }
    });

    logger.info("size:{}", miniPhotosDiv.size());
  }
}
