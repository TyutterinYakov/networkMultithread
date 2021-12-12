package edu;


import java.io.IOException;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		for(int i=0; i<1000; i++) {
		SimpleClient sc = new SimpleClient();
		sc.start();
		}
		
	}


}
