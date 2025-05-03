package BackendAssignment013;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {
	
	private int portNumber;

	public Server_Socket(int portNumber) {
		
		this.portNumber = portNumber;
		
	}
	
	public void startServer() {
		
		ServerSocket serverSocket = null;
		
		try {
			
			serverSocket = new ServerSocket(portNumber);
			
			System.out.println("Welcome Client.What's Up?");
			
			while(true) {
				
				Socket client = serverSocket.accept();
				
				ClientThreads clientThread = new ClientThreads(client);
				
				clientThread.start();
				
				
			}	
						
		}
		
		catch (IOException e) {
			
			System.out.println(e.getMessage());

		}
		
		finally {
			
			if(serverSocket != null && !serverSocket.isClosed()) {

				try {
					
					System.out.println("Server Closed.");
										
					serverSocket.close();
					
				} 
				
				catch (IOException e) {
					
					System.out.println(e.getMessage());
				
				}
			
			}

		}
		
	}
	
	public static void main(String[] args) {
		
		int portNumber = 1246;
		
		Server_Socket server_Socket = new Server_Socket(portNumber);
		
		System.out.println("----- Server -----\nServer started in its portnumber : " + portNumber);
		
		server_Socket.startServer();
		
	}

}
