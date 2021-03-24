package com.tudi.yb.util.ws;

import java.io.Closeable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebSocketSender implements Closeable {

  final private Logger logger = LoggerFactory.getLogger(this.getClass());

  private String addr;
  private String port;
  private OkHttpClient client = null;
  private WebSocket socket = null;
  private MyWebSockerListener listener = null;

  public void open(String addr, String port) {
    this.addr = addr;
    this.port = port;
    String url = "ws://" + this.addr + ":" + this.port;
    this.client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).build();
    Request request = new Request.Builder().url(url).build();
    this.listener = new MyWebSockerListener();
    this.socket = client.newWebSocket(request, this.listener);
  }

  public boolean isSocketOpened() {
    if (this.listener == null) {
      return false;
    } else {
      return this.listener.alive;
    }
  }

  public String syncSend(String message) throws Exception {
    this.listener.latch = new CountDownLatch(1);
    if (!this.socket.send(message)) {
      throw new Exception("Sending Message '" + message + "' is Failed");
    }
    try {
      this.listener.latch.await();
    } catch (InterruptedException e) {
      throw new Exception(e.toString());
    }
    if (this.listener.is_success) {
      return this.listener.response_msg;
    } else {
      throw new Exception(this.listener.response_msg);
    }
  }

  @Override
  public void close() {
    if (this.socket != null) {
      this.socket.close(1000, "結束");
    }
    if (this.client != null) {
      this.client.dispatcher().executorService().shutdown();
    }
  }

  public static class MyWebSockerListener extends WebSocketListener {

    public CountDownLatch latch = null;
    public Response response = null;
    public String response_msg = null;
    public boolean is_success = false;
    public boolean alive = false;

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
      this.response = response;
      this.alive = true;
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
      this.response_msg = text;
      this.response.close();
      this.is_success = true;
      this.latch.countDown();
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
      this.alive = false;
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
      super.onFailure(webSocket, t, response);
      this.is_success = false;
      if (t != null) {
        this.response_msg = t.getMessage();
      }
      if (this.response != null) {
        this.response.close();
      }
      this.latch.countDown();
    }
  }

  public static void main(String[] args) throws Exception {

  }

}
