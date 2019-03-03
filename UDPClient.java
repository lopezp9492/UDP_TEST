import java.net.*;
import java.io.*;

public class UDPClient {
	public static void main(String args[]) {
		//args give message contents and server hostname
		
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			
		}catch (SocketException e ) {System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null)aSocket.close();}
	}
}
