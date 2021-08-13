package com.bpm.service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {

  final protected Logger logger = LoggerFactory.getLogger(this.getClass());

  protected void callThreadSleep(int i) {
    try {
      Thread.sleep(i);
    } catch (InterruptedException ex) {
      logger.error(ex.getMessage(), ex);
    }
  }

  protected boolean waitForJSandJQueryToLoad(WebDriver driver) {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    // wait for jQuery to load
    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        try {
          return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
        } catch (Exception e) {
          // no jQuery present
          return true;
        }
      }
    };

    // wait for Javascript to load
    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState")
            .toString().equals("complete");
      }
    };
    return wait.until(jQueryLoad) && wait.until(jsLoad);
  }
}
