// Distributed Systems 
// Concepts and Design 5th Edition
// Figure 4.3 UDP client sends a message to the server and gets a reply

import java.net.*;
import java.io.*;

public class UDPClient {
	public static void main(String args[]) {
		//args give message contents and server hostname
		
		DatagramSocket aSocket = null;
		try {
			
			// SEND
			aSocket = new DatagramSocket();
			byte [] m args[0].getBytes(); //Message
			InetAddress aHost = InetAddress.getByName(args[1]); // Server Address
			int serverPort = 6789; // Server Port
			
			
			DatagramPacket request = new DatagramPacket (m, m.length, aHost, serverPort);
			aSocket.send(request);
			
			//RECEIVE
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			
			System.out.println("Reply: " + new String(reply.getData()));
			
		}catch (SocketException e ) {System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null)aSocket.close();}
	}
}
