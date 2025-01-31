package no.ntnu.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer extends Server {

  public static void main(String[] args) {
    MultiThreadedServer multiThreadedServer = new MultiThreadedServer();
  }

  public MultiThreadedServer() {
    try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
      isRunning = true;
      while (isRunning) {
        Socket socket = serverSocket.accept();
        ClientHandler clientHandler = new ClientHandler(socket);
        try {
          clientHandler.start();
        } catch (IllegalThreadStateException e) {
          System.out.println("Failed to start the client handler: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.out.println("Could not start the server.");
      e.printStackTrace();
    }
  }
}