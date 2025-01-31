package no.ntnu.server;

public class Server extends Thread {
	public static final int TCP_PORT = 1238; 
	protected ClientHandler clientHandler;
	protected boolean isRunning;

	protected Server() {
	}
}
