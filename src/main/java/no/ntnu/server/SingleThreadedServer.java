package no.ntnu.server;

import java.io.IOException;
import java.net.ServerSocket;

public class SingleThreadedServer extends Server {

  public static void main(String[] args) {
    SingleThreadedServer singleThreadedServer = new SingleThreadedServer();
  }

  public SingleThreadedServer() {
    try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
      isRunning = true;
      while (isRunning) {
        this.clientHandler = new ClientHandler(this, serverSocket.accept());
        this.clientHandler.run();
      }
    } catch (IOException e) {
      System.out.println("Could not start the server.");
      e.printStackTrace();
    }
  }
}
