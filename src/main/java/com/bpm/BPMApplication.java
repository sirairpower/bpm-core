package com.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BPMApplication {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
    SpringApplication.run(BPMApplication.class, args);
  }

}
