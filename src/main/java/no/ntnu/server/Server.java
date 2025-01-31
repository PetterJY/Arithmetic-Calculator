package no.ntnu.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static final int TCP_PORT = 1238; 
	private ClientHandler clientHandler;

	public static void main(String[] args) {
		Server server = new Server();
		server.run();
	}

	public void run() {
		this.clientHandler.start();
	}

	public Server() {
		try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
			this.clientHandler = new ClientHandler(this, serverSocket.accept());
		} catch (IOException e) {
			System.out.println("Failed to start the server: " + e.getMessage());
		}
	}
}
