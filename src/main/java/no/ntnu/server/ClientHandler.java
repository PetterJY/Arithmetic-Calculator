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
}
