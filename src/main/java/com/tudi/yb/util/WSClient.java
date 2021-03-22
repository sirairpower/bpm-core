package com.tudi.yb.util;

import com.tudi.yb.model.bo.YBMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

@Component
public class WSClient {
  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  public static void main(String... args) throws Exception{
    WSClient wsClient = new WSClient();
    wsClient.logger.debug("try connect");
    WebSocketClient client = new StandardWebSocketClient();

    WebSocketStompClient stompClient = new WebSocketStompClient(client);
    stompClient.setMessageConverter(new MappingJackson2MessageConverter());

    StompSessionHandler sessionHandler = new MyStompSessionHandler("");
    StompSession session = stompClient.connect("ws://127.0.0.1:5487/", sessionHandler).get();
    YBMessage ybMessage = new YBMessage();
    ybMessage.setType("TZSWN");
    ybMessage.setAction("apply");
    ybMessage.setInstCode("7023");
    ybMessage.setTransCode("YB001");
    ybMessage.setData1("{\\\"rdzlsh\\\":\\\"20210322\\\",\\\"czyzh\\\":\\\"\\\",\\\"dzpz\\\":\\\"\\\"}");
    ybMessage.setData2("");
    ybMessage.setNo(4627477);
    session.send("",ybMessage);
    new Scanner(System.in).nextLine(); // Don't close immediately.
  }



  public static void testOne(WSClient wsClient){

    try {
      WebSocketClient simpleWebSocketClient =
          new StandardWebSocketClient();
      List<Transport> transports = new ArrayList<>(1);
      transports.add(new WebSocketTransport(simpleWebSocketClient));

      SockJsClient sockJsClient = new SockJsClient(transports);
      WebSocketStompClient stompClient =
          new WebSocketStompClient(sockJsClient);
      stompClient.setMessageConverter(new MappingJackson2MessageConverter());

      String url = "ws://127.0.0.1:5487/";
      String userId = "spring-" +
          ThreadLocalRandom.current().nextInt(1, 99);
      StompSessionHandler sessionHandler = new MyStompSessionHandler(userId);
      StompSession session = stompClient.connect(url, sessionHandler).get();

      for (;;) {
//        Thread.sleep(5000L);
        wsClient.logger.debug(userId + " >> ");

        session.send("", "\t{\n"
            + "\t\t\"action\": 0, \n"
            + "\t\t\"data\": \"\"\n"
            + "\t}");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {


    }
  }
}
