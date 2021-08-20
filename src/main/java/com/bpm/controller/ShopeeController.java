package com.bpm.controller;

import com.bpm.service.ShopeeService;
import java.util.ArrayList;
import java.util.Arrays;
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
    }
    return "Completed well show on page ~ ";
  }

  public static void main(String... args) throws Exception {
    //extract (（(.*?)）)", "(\\((.*?)\\))", "(【(.*?)】)", "(≡(.*?)≡)", "(<<(.*?)>>)"
    //split by (" ","-","/","、")

    List<String> extractREGEXs = Arrays.asList("(（(.*?)）)", "(\\((.*?)\\))", "(【(.*?)】)", "(★(.*?)★)", "(≡(.*?)≡)", "(<<(.*?)>>)", "(\\d+ml)", "(\\d+g)");
    String subject = "(大送小)愛斯德瑪 玻尿酸瞬效保濕精華液60ml、118ml、30ml(公司貨)≡條紋斑比≡新科若林 傳明酸淡斑精華液15ml / 30ml -公司貨 ≡條紋斑比≡<<年末賠本賣>>CureCare (中文標公司貨) 安炫曜【xxx】 （台灣代理中文標公司貨）白酵胎盤精華原液 98.75%-30ml (日本製.文標公司貨)";
    for (String ex : extractREGEXs) {
      subject = extractBy(ex, subject)[0];
      System.out.println("extract subject : " + subject);
    }
    Arrays.asList(subject.split("[\\s/\\-、]")).forEach(s -> {
      System.out.println("s : " + s);
    });
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
