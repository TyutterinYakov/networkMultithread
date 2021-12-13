package edu.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;

import edu.Greetable;

public class ServerSimple extends Thread {
	
	private Socket soc;
	private Map<String, Greetable> handlers;
	
	public ServerSimple(Socket soc, Map<String, Greetable> handlers) {
		this.soc = soc;
		this.handlers = handlers;
	}
	
	public void run() {
		handleRequest();
	}

	private void handleRequest() {
		try {
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
			
			String request = br.readLine();
			String[] lines = request.split("\\s+");
			String command = lines[0];
			String userName = lines[1];
			
			System.out.println("server got string 1: "+command);
			System.out.println("server got string 2: "+userName);
			
			String response = buildResponse(command, userName);
			
			bw.write(response);
			bw.newLine();
			bw.flush();
			
			br.close();
			bw.close();
			soc.close();
			
			
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
		
	}

	private String buildResponse(String command, String userName) {
		
		Greetable handler = handlers.get(command);
		if(handler!=null) {
			return handler.buildResponse(userName);
		}
		return"Hello "+userName;
	}
}
