package edu;


import java.io.IOException;
import java.net.UnknownHostException;

import edu.simple.SimpleClient;

public class Client {
	

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		for(int i=0; i<5; i++) {
		SimpleClient sc = new SimpleClient(i);
		sc.start();
		}
		
	}


}
