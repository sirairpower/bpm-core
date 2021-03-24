package com.tudi.yb.util.ws;

import com.tudi.yb.model.bo.TZSWNMessage;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebSocketSenderTest {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  WebSocketSender webSocketSender;

  @Test
  void syncSend() {
    webSocketSender.open("localhost","5487");
    TZSWNMessage TZSWNMessage = new TZSWNMessage();
    TZSWNMessage.setType("TZSWN");
    TZSWNMessage.setAction("apply");
    TZSWNMessage.setInstCode("7023");
    TZSWNMessage.setTransCode("YB001");
    TZSWNMessage.setData1("{\\\"rdzlsh\\\":\\\"20210322\\\",\\\"czyzh\\\":\\\"\\\",\\\"dzpz\\\":\\\"\\\"}");
    TZSWNMessage.setData2("");
    TZSWNMessage.setNo(4627477);
//    logger.info("{}",new Gson().fromJson(webSocketSender.syncSend(ybMessage));
//    try (WebSocketSender sender = new WebSocketSender("localhost", "5487")) {
//      String message1 = new TZSWNInput("TZSWN", "apply", "01635", "YB001", new YB001Input("", "").tojson(), "", "").tojson();
//      String message2 = new TZSWNInput("TZSWN", "apply", "01635", "KC22", new KC22Input("0").tojson(), "", "").tojson();
//      System.out.println("Start To Send message1");
//      System.out.println("Return: " + new Gson().fromJson(sender.syncSend(message1), SocketOutput.class).tojson());
//      System.out.println("Start To Send message2");
//      System.out.println("Return: " + new Gson().fromJson(sender.syncSend(message2), SocketOutput.class).tojson());
//      System.out.println("Finish");
//    }
  }
}
