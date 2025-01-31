package no.ntnu.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
  private Server server;
  private Socket socket;
  private BufferedReader reader;
  private PrintWriter writer;

  public ClientHandler(Server server, Socket socket) throws IOException {
    this.server = server;
    this.socket = socket;
    this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.writer = new PrintWriter(socket.getOutputStream(), true);
  }

  @Override
  public void run() {
    try {
      double result = receive();
      this.writer.println(result);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private double receive() throws IOException {
    String message = this.reader.readLine();

    String[] parts = message.split("-");

    double result =
        arithmeticOperation(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));

    return result;
  }

  public double arithmeticOperation(String operation, double x, double y) {
    return switch (operation) {
      case "A" -> x + y;
      case "S" -> x - y;
      case "M" -> x * y;
      case "D" -> x / y;
      default -> 0;
    };
  }

  public void send(double result) {

  }
}
