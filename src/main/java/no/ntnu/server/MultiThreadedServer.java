package no.ntnu.server;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiThreadedServer extends Server {

  public static void main(String[] args) {
    MultiThreadedServer multiThreadedServer = new MultiThreadedServer();
  }

  public MultiThreadedServer() {
    try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
      isRunning = true;
      while (isRunning) {
        this.clientHandler = new ClientHandler(this, serverSocket.accept());
        this.clientHandler.start();
      }
    } catch (IOException e) {
      System.out.println("Could not start the server.");
      e.printStackTrace();
    }
  }
}