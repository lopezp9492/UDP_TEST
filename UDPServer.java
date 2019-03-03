// Distributed Systems 
// Concepts and Design 5th Edition
// Figure 4.4 UDP Server repeatedly receives a request and sends it back to the client

import java.net.*;
import java.io.*;

public class UDPServer {

	private static final int PORT = 6789;
	private static final int BUFFER_SIZE = 1000;

	
	public static void main(String[] args) {
		DatagramSocket aSocket = null;
		
		try {
			aSocket = new DatagramSocket(PORT);
			byte[] buffer  = new byte[BUFFER_SIZE];
			
			while(true)
			{
				
			}
			
		}catch (SocketException e ) {System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null)aSocket.close();}

	}

}
