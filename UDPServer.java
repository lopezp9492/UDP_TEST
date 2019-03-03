// Distributed Systems 
// Concepts and Design 5th Edition
// Figure 4.4 UDP Server repeatedly receives a request and sends it back to the client

import java.net.*;
import java.io.*;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class UDPServer {

	private static final int PORT = 6790;
	private static final int BUFFER_SIZE = 1000;

	
	public static void main(String[] args) {
		//Get Process Name
	    RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        String jvmName = bean.getName();
        System.out.println("Name = " + jvmName);
        
        // Extract the PID by splitting the string returned by the
        // bean.getName() method.
        long pid = Long.valueOf(jvmName.split("@")[0]);
        System.out.println("PID  = " + pid);
	    
	    
		DatagramSocket aSocket = null;
		boolean running = true;
		
		try {
			aSocket = new DatagramSocket(PORT);
			byte[] buffer  = new byte[BUFFER_SIZE];
			
			System.out.println("Server Started..." );

			
			
			while(running)
			{
				// Receive
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				
				//Print Clients Message;
				System.out.println("Received: " + new String(request.getData() ) );
	            
				//Create Reply
	            String mStr = "Hello from Server pid:" + pid;
	            byte [] m =  mStr.getBytes(); // Message
				
				// Send
				DatagramPacket reply = new DatagramPacket(m,
						m.length, request.getAddress(), request.getPort());
				aSocket.send(reply);
			}
			
		}catch (SocketException e ) {System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {
			if(aSocket != null)aSocket.close();
			System.out.println("Socket Closed." );
		}

	}

}
