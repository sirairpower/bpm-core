package com.bpm.service;

import com.bpm.dao.ShopeeProductInfoRepository;
import com.bpm.model.ShopeeProductInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ShopeeServiceImplTest {

  Logger logger = LoggerFactory.getLogger(this.getClass());
  String url = "https://woocommerce-620799-2067897.cloudwaysapps.com/wp-admin/";
  String URI_CATEGORY = "edit-tags.php?taxonomy=product_cat&post_type=product";
  String URI_ADD_PROD = "/post-new.php?post_type=product";
  String user = "howard_chang@bpm.tw";
  String password = "tIcte0-vabhum-bojjaw";

  @Autowired
  private DownloadService downloadService;
  @Autowired
  private ShopeeProductInfoRepository productInfoRepository;
  @Autowired
  private ShopeeService shopeeService;

  @BeforeAll
  static void setupAllAtOnce() {
    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
  }

  @Test
  void fixImgsTest() {
    shopeeService.fixImgs();
  }

  @Test
  void inputProdToBambi() {
    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");

    WebDriver driver = new ChromeDriver();
    try {
      driver.manage().window().maximize();
      //into wp-admin
      driver.get(url);
      WebElement wpSubmit = new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("wp-submit")));
      WebElement userLogin = driver.findElement(By.id("user_login"));
      WebElement userPass = driver.findElement(By.id("user_pass"));
      userLogin.clear();
      userLogin.sendKeys(user);
      userPass.clear();
      userPass.sendKeys(password);
      wpSubmit.click();
      WebElement savePoint = new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("save-post")));
      logger.info("{} login wp-admin succeed!", user);

      List<ShopeeProductInfo> prods = productInfoRepository.fetchAllWithVariantion();
      //establish category
//      extablishCategory(driver, prods);

      //add new prod
      driver.get(url + URI_ADD_PROD);
      new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("publish")));
      prods.forEach(prod -> {
        logger.debug("prod id:{}", prod.getId());
        if (prod.getVariantProdTrue()) {
          prod.getShopeeVariantProds().forEach(pv -> {
            logger.debug("variant id:{}", pv.getId());
          });
        }
      });

//      WebElement title = driver.findElement(By.id("title"));
//      title.sendKeys();
      Thread.sleep(5000);
    } catch (InterruptedException ex) {
      logger.error(ex.getMessage(), ex);
    } finally {
      driver.close();
      driver.quit();
    }
  }

  private void extablishCategory(WebDriver driver, List<ShopeeProductInfo> prods) {
    driver.get(url + URI_CATEGORY);
    new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(By.id("search-submit")));
    Set<String> categoryNames = prods.stream().map(ShopeeProductInfo::getCategoryName).collect(Collectors.toSet());
    categoryNames.forEach(cName -> {
      logger.debug("cName:{}", cName);
      WebElement tagSearchInput = driver.findElement(By.id("tag-search-input"));
      tagSearchInput.sendKeys(cName);
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

  @Test
  void tidyDataTest() {
    List<String> extractREGEXs = Arrays.asList("(（(.*?)）)", "(\\((.*?)\\))", "(【(.*?)】)", "(★(.*?)★)", "(≡(.*?)≡)", "(<<(.*?)>>)", "(\\d+ml)", "(\\d+g)");
    productInfoRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).forEach(prod -> {
      String subjectPristine = prod.getSubjectPristine();
      logger.debug("id , subject :{},{}", prod.getId(), subjectPristine);
      //remove more than one line
      try (BufferedReader br = new BufferedReader(new StringReader(subjectPristine))) {
        subjectPristine = br.readLine();
        logger.debug("after remove line more than 1.");
        logger.debug("{}", subjectPristine);
      } catch (IOException e) {
        logger.error(e.getMessage(), e);
      }
      //split by space,(xxx),【xxx】,≡xxx≡,<<xxx>>,"-","/","、"
      for (String ex : extractREGEXs) {
        subjectPristine = extractBy(ex, subjectPristine)[0];
        logger.debug("extract subject : {}", subjectPristine);
      }
      // digit , digit+unit , unit , digit+unit/digit+unit

      List<String> result = Arrays.asList(subjectPristine.split("[\\s/\\-、]")).stream().filter(s -> (StringUtils.isNotBlank(s))).collect(Collectors.toList());
      logger.debug("subject result : {}", String.join(" ", result));

    });
  }

  /**
   * @param regex
   * @param target
   * @return [0]:result of extracted , [1]:extracted word
   */
  private String[] extractBy(String regex, String target) {
    String[] result = new String[2];
    final Pattern p = Pattern.compile(regex);
    Matcher matcher = p.matcher(target);
    final List<String> whichFounded = new ArrayList<>();
    while (matcher.find()) {
      whichFounded.add(matcher.group(1));
      logger.debug("found : " + matcher.group(1));
      target = StringUtils.remove(target, matcher.group(1));
    }
    result[0] = target;
    if (whichFounded.size() > 0) {
      result[1] = String.join(",", whichFounded);
      logger.debug("removed : " + result[1]);
    }
    return result;
  }

  @Test
  void getContentType() throws IOException {
    URL url = new URL("https://cf.shopee.tw/file/1306fc0f2a2cb711fe1559353ed9e055");
    URLConnection conn = url.openConnection();
    String contentType = conn.getContentType();
    logger.info("contentType:{}", contentType);
  }

  @Test
  void loadFileToLocal() throws IOException {
//    String tmpdir = System.getProperty("java.io.tmpdir");
//    FileUtils.forceMkdirParent(new File(fileStoragePath));
    downloadService.loadFileToLocal();
  }

}
