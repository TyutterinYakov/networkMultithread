package edu;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket socket = new ServerSocket(25525);
		System.out.println("Server is started");
		while(true) {
			
			Socket client = socket.accept();
			ServerSimple sr = new ServerSimple(client);
			sr.start();
//			Socket client = socket.accept();
//			handleRequest(client);
		}
	}

}
