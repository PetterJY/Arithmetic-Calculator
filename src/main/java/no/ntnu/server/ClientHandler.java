package no.ntnu.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
  private Socket socket;
  private BufferedReader reader;
  private PrintWriter writer;

  public ClientHandler(Socket socket) throws IOException {
    this.socket = socket;
    this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.writer = new PrintWriter(socket.getOutputStream(), true);
  }

  @Override
  public void run() {
    String message = null;
    try {
      message = this.reader.readLine();
    } catch (IOException e) {
      System.out.println("Failed to receive message: " + e.getMessage());
    }
    String[] parts = message.split("-");

    double result =
        arithmeticOperation(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));

    writer.println(result);
  }

  public double arithmeticOperation(String operation, double x, double y) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return switch (operation) {
      case "A" -> x + y;
      case "S" -> x - y;
      case "M" -> x * y;
      case "D" -> x / y;
      default -> 0;
    };
  }
}
