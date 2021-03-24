package com.tudi.yb.util.ws;

import com.google.gson.Gson;
import com.tudi.yb.model.bo.TZSWNMessage;
import com.tudi.yb.model.bo.YBMessageInterface;
import java.net.URI;
import java.util.Scanner;
import lombok.Data;
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
@Data
public class WSClient {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  public void sendMsg(TextWebSocketHandler textWebSocketHandler, YBMessageInterface ybMessage,URI uri) {
    try {
      WebSocketClient webSocketClient = new StandardWebSocketClient();
      WebSocketSession webSocketSession = webSocketClient.doHandshake(textWebSocketHandler,new WebSocketHttpHeaders(), uri).get();
      TextMessage message = new TextMessage(new Gson().toJson(ybMessage));
      webSocketSession.sendMessage(message);
      logger.info("sent message - " + message.getPayload());

    } catch (Exception e) {
      logger.error("Exception while accessing websockets", e);
    }

  }

  public void sendMsg() {
    try {
      WebSocketClient webSocketClient = new StandardWebSocketClient();

      WebSocketSession webSocketSession = webSocketClient.doHandshake(new TextWebSocketHandler() {
        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) {
          logger.info("received message - " + message.getPayload());
        }

        @Override
        public void afterConnectionEstablished(WebSocketSession session) {
          logger.info("established connection - " + session);
        }
      }, new WebSocketHttpHeaders(), URI.create("ws://127.0.0.1:5487")).get();
      TZSWNMessage TZSWNMessage = new TZSWNMessage();
      TZSWNMessage.setType("TZSWN");
      TZSWNMessage.setAction("apply");
      TZSWNMessage.setInstCode("7023");
      TZSWNMessage.setTransCode("YB001");
      TZSWNMessage.setData1("{\\\"rdzlsh\\\":\\\"20210322\\\",\\\"czyzh\\\":\\\"\\\",\\\"dzpz\\\":\\\"\\\"}");
      TZSWNMessage.setData2("");
      TZSWNMessage.setNo(4627477);
      TextMessage message = new TextMessage(new Gson().toJson(TZSWNMessage));
      webSocketSession.sendMessage(message);

      logger.info("sent message - " + message.getPayload());

    } catch (Exception e) {
      logger.error("Exception while accessing websockets", e);
    }

  }

  public static void main(String... args) throws Exception {
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
      TZSWNMessage TZSWNMessage = new TZSWNMessage();
      TZSWNMessage.setType("TZSWN");
      TZSWNMessage.setAction("apply");
      TZSWNMessage.setInstCode("7023");
      TZSWNMessage.setTransCode("YB001");
      TZSWNMessage.setData1("{\\\"rdzlsh\\\":\\\"20210322\\\",\\\"czyzh\\\":\\\"\\\",\\\"dzpz\\\":\\\"\\\"}");
      TZSWNMessage.setData2("");
      TZSWNMessage.setNo(4627477);
      TextMessage message = new TextMessage(new Gson().toJson(TZSWNMessage));
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
