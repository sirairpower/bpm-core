package com.bpm.service;

import com.bpm.dao.ShopeeProductInfoRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
