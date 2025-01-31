package no.ntnu.server;

import java.net.Socket;

public class ClientHandler {
  private Server server;
  private Socket socket;

  public ClientHandler(Server server, Socket socket) {
    this.server = server;
    this.socket = socket;
  }

  public void start() {
    
  }

  public double artithmeticOperation(char operation, double x, double y) {
    return switch (operation) {
      case 'A' -> x + y;
      case 'S' -> x - y;
      case 'M' -> x * y;
      case 'D' -> x / y;
      default -> 0;
    };
  }
}
