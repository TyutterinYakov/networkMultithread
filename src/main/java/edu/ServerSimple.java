package edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerSimple extends Thread {
	
	private Socket soc;
	
	public ServerSimple(Socket soc) {
		this.soc = soc;
	}
	
	public void run() {
		handleRequest();
	}

	private void handleRequest() {
		try {
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
			
			StringBuilder sb = new StringBuilder("Hello, ");
			String userName = br.readLine();
			
			System.out.println("server got string: "+userName);
			Thread.sleep(2000);
			sb.append(userName);
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
			
			br.close();
			bw.close();
			soc.close();
			
			
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace(System.out);
		}
		
	}
}
