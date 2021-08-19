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
    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
    WebDriver driver = new ChromeDriver();
//    getPhotos(logger, driver);
//    getSubject(logger);
    try {
      driver.manage().window().maximize();
      driver.get("https://shopee.tw/%E5%85%AC%E5%8F%B8%E8%B2%A8Kneipp%E5%85%8B%E5%A5%88%E5%9C%83-%E8%8A%B3%E9%A6%99%E7%B2%BE%E6%B2%B9%E5%8E%9F%E5%A7%8B%E9%B9%BD%E6%B3%89%E6%B5%B4%E9%B9%BD-500g(%E5%B0%A4%E5%8A%A0%E5%88%A9.%E8%96%B0%E8%A1%A3%E8%8D%89.%E6%84%9C%E6%84%8F%E5%B0%8F%E6%86%A9.%E7%BA%88%E8%8D%89%E5%95%A4%E9%85%92%E8%8A%B1.%E6%9D%9C%E6%9D%BE.%E5%B1%B1%E9%87%91%E8%BB%8A.%E7%BE%8E%E5%A5%BD%E6%99%82%E5%85%89)-i.2901888.1646210753?position=3");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        logger.error(ex.getMessage(), ex);
      }
      WebElement primaryBtn = new WebDriverWait(driver, 5L)
          .until(ExpectedConditions.elementToBeClickable(By.className("btn-solid-primary")));
      WebElement selectionDiv = new WebDriverWait(driver, 60L)
          .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[3]/div")));
      List<WebElement> choiceBtns = selectionDiv.findElements(By.className("product-variation"));
      Actions hover = new Actions(driver);
      choiceBtns.forEach(btn -> {

        logger.info("btn : {}", btn.getText());
        hover.moveToElement(btn).build().perform();
        WebElement photoDiv = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div")));
//      WebElement photoDiv = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div"));
        String backgroundImage = photoDiv.getCssValue("background-image");
        if (StringUtils.isNotBlank(backgroundImage)) {
          backgroundImage = StringUtils.remove(backgroundImage, "url(\"");
          backgroundImage = StringUtils.remove(backgroundImage, "\")");
          logger.info("contain backgroundImage:{}", backgroundImage);
        } else {
          logger.warn("Miss backgroundImage");
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          logger.error(ex.getMessage(), ex);
        }
//        if (StringUtils.contains(btn.getAttribute("class"), "product-variation--disabled")) {
//        } else {
//          List<WebElement> ticks = btn.findElements(By.className("product-variation__tick"));
//          if (ticks.size() == 0) {
//            btn.click();
//          }
//          WebElement tickDiv = new WebDriverWait(driver, 3L).until(ExpectedConditions.presenceOfElementLocated(By.className("product-variation__tick")));
//        }

      });
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
    } finally {
      driver.close();
      driver.quit();
    }

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
