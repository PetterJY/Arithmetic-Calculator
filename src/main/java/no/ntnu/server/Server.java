package no.ntnu.server;

public abstract class Server extends Thread {
	public static final int TCP_PORT = 1238; 
	protected boolean isRunning;
	
	protected Server() {
	}
}
