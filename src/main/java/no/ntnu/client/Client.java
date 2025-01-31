package no.ntnu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static final int TCP_PORT = 1238;
  private Socket socket;
  private BufferedReader reader;
  private PrintWriter writer;
  private boolean running;

  public static void main(String[] args) {

    Thread thread1 = new Thread(() -> {
      Client client1 = new Client();
      client1.calculate('A', 50, 20);
    });
    Thread thread2 = new Thread(() -> {
      Client client2 = new Client();
      client2.calculate('S', 60, 20);
    });
    Thread thread3 = new Thread(() -> {
      Client client3 = new Client();
      client3.calculate('M', 15, 5);
    });
    Thread thread4 = new Thread(() -> {
      Client client4 = new Client();
      client4.calculate('D', 100, 10);
    });
    Thread thread5 = new Thread(() -> {
      Client client5 = new Client();
      client5.calculate('A', 70, 10);
    });
    Thread thread6 = new Thread(() -> {
      Client client6 = new Client();
      client6.calculate('S', 80, 20);
    });
    Thread thread7 = new Thread(() -> {
      Client client7 = new Client();
      client7.calculate('M', 25, 5);
    });
    Thread thread8 = new Thread(() -> {
      Client client8 = new Client();
      client8.calculate('D', 200, 10);
    });
    Thread thread9 = new Thread(() -> {
      Client client9 = new Client();
      client9.calculate('A', 90, 10);
    });
    Thread thread10 = new Thread(() -> {
      Client client10 = new Client();
      client10.calculate('S', 100, 20);
    });

    long time = System.nanoTime();

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
    thread6.start();
    thread7.start();
    thread8.start();
    thread9.start();
    thread10.start();

    try {
      thread1.join();
      thread2.join();
      thread3.join();
      thread4.join();
      thread5.join();
      thread6.join();
      thread7.join();
      thread8.join();
      thread9.join();
      thread10.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Time spent: " + (System.nanoTime() - time) / 1000000 + " ms");
  }

  public Client() {
    this.running = false;
  }

  public void calculate(char operation, double x, double y) {
    establishConnection();
    send(operation, x, y);
    receive();
  }

  public void establishConnection() {
    if (!running) {
      try {
        this.socket = new Socket("localhost", TCP_PORT);
      } catch (IOException e) {
        System.out.println("Failed to connect to the server: " + e.getMessage());
      } try {
        this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.writer = new PrintWriter(this.socket.getOutputStream(), true);
      } catch (IOException e) {
        System.out.println("Failed to create Writer and Reader: " + e.getMessage());
        throw new IllegalArgumentException("Could not create writer and reader");
      }
    }
  }

  public void send(char operation, double x, double y) {
    this.writer.println(operation + "-" + x + "-" + y); //A S M D
  }

  public void receive() {
    try {
      double result = Double.parseDouble(this.reader.readLine());
    } catch (IOException e) {
      System.out.println("Failed to receive the result: " + e.getMessage());
    } 
  }
}