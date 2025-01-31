package no.ntnu.server;

import java.io.IOException;
import java.net.ServerSocket;

public class SingleThreadedServer extends Server {
  public static final int TCP_PORT = 1238;
  private ClientHandler clientHandler;

  public static void main(String[] args) {
    Server server = new Server();
    server.run();
  }

  public SingleThreadedServer() {
    try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
      this.clientHandler = new ClientHandler(this, serverSocket.accept());
    } catch (IOException e) {
      System.out.println("Could not start the server.");
      e.printStackTrace();
    }
  }
}
