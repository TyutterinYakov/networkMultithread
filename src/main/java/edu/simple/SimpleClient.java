package edu.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class SimpleClient extends Thread {
	private final static String[] COMMAND = {
			"HELLO", "MORNING", "DAY", "EVENING"
	};
	private int cmdNumber;

	public SimpleClient(int cmdNumber) {
		this.cmdNumber = cmdNumber;
	}
	public void run() {
		
		try {
		//	System.out.println("Started: "+LocalDateTime.now());
			Socket client = new Socket("127.0.0.1",25525);
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		
		String command = COMMAND[cmdNumber%COMMAND.length];
		String sb = command +" "+"Yasha";
		bw.write(sb);
		bw.newLine();
		bw.flush();
		
		
		String answer = br.readLine();
		
		System.out.println("Client got string:  "+answer);
		br.close();
		bw.close();
	//	System.out.println("Finished: "+LocalDateTime.now());
		} catch(IOException ex) {
			ex.printStackTrace(System.out);
		}
	}
}
