package com.bpm.controller;

import com.bpm.service.ShopeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopeeController {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  ShopeeService shopeeService;

  @RequestMapping("/shopee/{mode}")
  public String shopeeBanbi(@PathVariable String mode) throws InterruptedException {
    logger.info("shopeeBanbi mode:{}", mode);
    if (StringUtils.equals(mode, "new")) {
      shopeeService.getBanbiSite();
    } else if (StringUtils.equals(mode, "tidyData")) {
      shopeeService.tidyData();
    } else if (StringUtils.equals(mode, "fixImgs")) {
      shopeeService.fixImgs();
    }
    return "Completed well show on page ~ ";
  }

  public static void main(String... args) throws Exception {
  }

  private static String[] extractBy(String regex, String target) {
    String[] result = new String[2];
    final Pattern p = Pattern.compile(regex);
    Matcher matcher = p.matcher(target);
    List<String> whichFounded = new ArrayList<>();
    while (matcher.find()) {
      whichFounded.add(matcher.group(1));
      System.out.println("found : " + matcher.group(1));
      target = StringUtils.remove(target, matcher.group(1));
    }
    result[0] = target;
    if (whichFounded.size() > 0) {
      result[1] = String.join(",", whichFounded);
      System.out.println("removed : " + result[1]);
    }
    return result;
  }

}
