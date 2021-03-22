package com.tudi.yb.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @RequestMapping("/first/{name}")
    public String firstVisit(@PathVariable String name){
      return "Hello ~ "+ name;
    }



}
