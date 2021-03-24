package com.tudi.yb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tudi.yb.model.bo.TZSWNMessage;
import com.tudi.yb.model.bo.YB001;
import com.tudi.yb.model.bo.YB16;
import com.tudi.yb.util.ws.WSClient;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//TODO - Take off .Just for poc.
@RestController
public class FirstController {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private WSClient wsClient;

  @RequestMapping("/first/{name}")
  public String firstVisit(@PathVariable String name) {
    return "Hello ~ " + name;
  }

  @GetMapping(value = "/testws",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public DeferredResult<String> testws() {
    TZSWNMessage TZSWNMessage = new TZSWNMessage();
    TZSWNMessage.setType("TZSWN");
    TZSWNMessage.setAction("apply");
    TZSWNMessage.setInstCode("7023");
    TZSWNMessage.setTransCode("YB001");
    YB001 yb001 = new YB001("20210322", "", "");
    TZSWNMessage.setData1(yb001);
    TZSWNMessage.setData2("");
    TZSWNMessage.setNo(4627477);

    DeferredResult<String> result = new DeferredResult<>();
    wsClient.sendMsg(new TextWebSocketHandler() {
      @Override
      public void handleTextMessage(WebSocketSession session, TextMessage message) {
        logger.info("received message - " + message.getPayload());
        result.setResult(message.getPayload());
      }

      @Override
      public void afterConnectionEstablished(WebSocketSession session) {
        logger.info("established connection - " + session);
      }
    }, TZSWNMessage, URI.create("ws://127.0.0.1:5487"));
    return result;
  }

  @GetMapping(value = "/testyb16",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public DeferredResult<String> testyb16() {
    TZSWNMessage TZSWNMessage = new TZSWNMessage();
    TZSWNMessage.setType("TZSWN");
    TZSWNMessage.setAction("apply");
    TZSWNMessage.setInstCode("317308");
    TZSWNMessage.setTransCode("YB16");
    YB16 yb16 = new YB16(0);
    TZSWNMessage.setData1(yb16);
    TZSWNMessage.setData2("");
    TZSWNMessage.setNo(234498);

    DeferredResult<String> result = new DeferredResult<>();
    wsClient.sendMsg(new TextWebSocketHandler() {
      @Override
      public void handleTextMessage(WebSocketSession session, TextMessage message) {
        logger.info("received message - " + message.getPayload());
        result.setResult(message.getPayload());
      }

      @Override
      public void afterConnectionEstablished(WebSocketSession session) {
        logger.info("established connection - " + session);
      }
    }, TZSWNMessage, URI.create("ws://127.0.0.1:5487"));
    return result;
  }

  public static void main(String... args) throws Exception{
    ObjectMapper objectMapper = new ObjectMapper();

    // User Object 轉 json
    YB16 yb16 = new YB16(0);
    String json = objectMapper.writeValueAsString(yb16);

    // json 轉 User Object
    YB16 yb16_2 = objectMapper.readValue(json, YB16.class);

    // List<User> 轉 json
    List<YB16> lists = new ArrayList<>();
    YB16 yb16_1 = new YB16(123);
    lists.add(yb16_1);
    lists.add(yb16_2);
    System.out.println(objectMapper.writeValueAsString(lists));

  }
}
