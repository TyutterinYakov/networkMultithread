package edu;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import edu.simple.ServerSimple;

public class Server {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket socket = new ServerSocket(25525);
		System.out.println("Server is started");
		Map<String, Greetable> handlers = loadHandlers();
		
		while(true) {
			
			Socket client = socket.accept();
			new ServerSimple(client, handlers).start();
			
		}
	}

	private static Map<String, Greetable> loadHandlers() {
		Map<String, Greetable> result = new HashMap<>();
		
        try (InputStream is = Server.class.getClassLoader()
                .getResourceAsStream("server.properties")) {

        	Properties properties = new Properties();
            properties.load(is);
            
            for(Object cmd : properties.keySet()) {
            	String className = properties.getProperty(cmd.toString());
            	
            	Class<Greetable> cl = (Class<Greetable>) Class.forName(className);
            	
            	Greetable handler = cl.getConstructor().newInstance();
            	result.put(cmd.toString(), handler);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
		
		return result;
	}

}
