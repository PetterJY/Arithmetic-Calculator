package no.ntnu.server;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiThreadedServer extends Server {

  public static void main(String[] args) {
    Server server = new Server();
    server.run();
  }

  public MultiThreadedServer() {
    try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
      //this.clientHandler = new ClientHandler(this, serverSocket.accept());
    } catch (IOException e) {
      System.out.println("Could not start the server.");
      e.printStackTrace();
    }
  }
}
