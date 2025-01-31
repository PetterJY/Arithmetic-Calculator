package no.ntnu.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server extends Thread {
	public static final int TCP_PORT = 1238; 
	private ClientHandler clientHandler;

	public Server() {
		try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
			this.clientHandler = new ClientHandler(this, serverSocket.accept());
		} catch (IOException e) {
			System.out.println("Could not start the server.");
			e.printStackTrace();
		}
	}
}
