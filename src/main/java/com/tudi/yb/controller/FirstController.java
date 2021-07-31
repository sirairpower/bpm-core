package com.tudi.yb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO - Take off .Just for poc.
@RestController
public class FirstController {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  @RequestMapping("/first/{name}")
  public String firstVisit(@PathVariable String name) {
    return "Hello ~ " + name;
  }

  public static void main(String... args) throws Exception {

  }
}
