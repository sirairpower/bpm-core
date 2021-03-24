package com.tudi.yb.util;

import com.google.gson.Gson;
import com.tudi.yb.model.bo.YBMessage;
import java.net.URI;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WSClient {
  final private Logger logger = LoggerFactory.getLogger(this.getClass());




  public static void main(String... args) throws Exception{
    WSClient wsClient = new WSClient();

    try {
      WebSocketClient webSocketClient = new StandardWebSocketClient();

      WebSocketSession webSocketSession = webSocketClient.doHandshake(new TextWebSocketHandler() {
        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) {
          wsClient.logger.info("received message - " + message.getPayload());
        }

        @Override
        public void afterConnectionEstablished(WebSocketSession session) {
          wsClient.logger.info("established connection - " + session);
        }
      }, new WebSocketHttpHeaders(), URI.create("ws://127.0.0.1:5487")).get();
      YBMessage ybMessage = new YBMessage();
      ybMessage.setType("TZSWN");
      ybMessage.setAction("apply");
      ybMessage.setInstCode("7023");
      ybMessage.setTransCode("YB001");
      ybMessage.setData1("{\\\"rdzlsh\\\":\\\"20210322\\\",\\\"czyzh\\\":\\\"\\\",\\\"dzpz\\\":\\\"\\\"}");
      ybMessage.setData2("");
      ybMessage.setNo(4627477);
      TextMessage message = new TextMessage(new Gson().toJson(ybMessage));
      webSocketSession.sendMessage(message);

      wsClient.logger.info("sent message - " + message.getPayload());
      new Scanner(System.in).nextLine();
//      Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
//        try {
//          TextMessage message = new TextMessage(new Gson().toJson(ybMessage));
//          webSocketSession.sendMessage(message);
//          wsClient.logger.info("sent message - " + message.getPayload());
//        } catch (Exception e) {
//          wsClient.logger.error("Exception while sending a message", e);
//        }
//      }, 1, 10, TimeUnit.SECONDS);
    } catch (Exception e) {
      wsClient.logger.error("Exception while accessing websockets", e);
    }

  }

}
