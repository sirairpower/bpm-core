package com.tudi.yb.util;

import java.lang.reflect.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class MyStompSessionHandler implements StompSessionHandler {

  private String connName;

  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
    logger.debug("afterConnected");
  }

  @Override
  public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
    logger.debug("handleException");

  }

  @Override
  public void handleTransportError(StompSession session, Throwable exception) {
    logger.debug("handleTransportError");

  }

  @Override
  public Type getPayloadType(StompHeaders headers) {
    logger.debug("getPayloadType");
    return null;
  }

  @Override
  public void handleFrame(StompHeaders headers, Object payload) {
    logger.debug("handleFrame");

  }
}
