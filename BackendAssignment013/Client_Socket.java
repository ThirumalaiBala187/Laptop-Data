package BackendAssignment013;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_Socket {

	public Client_Socket() {
		
	}
	
	Scanner userInput = new Scanner(System.in);

	public void messageToServer() {
		
		Socket clientSocket = null;
		
		try {
			
			System.out.println("Please Enter the server's IP address : ");
			
			String serverIP = userInput.nextLine();
			
			System.out.println("Please Enter the port number : ");
			
			int portNumber = userInput.nextInt();
			
			userInput.nextLine();
			
			clientSocket = new Socket(serverIP, portNumber);
			
			DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
			
			DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
			
			String serverMsg = "";
			
			System.out.println(inputStream.readUTF());
			
			while (!serverMsg.equalsIgnoreCase("End")) {
				
				System.out.println("Enter your request to the server : ");
				
				serverMsg = userInput.nextLine();
				
				outputStream.writeUTF(serverMsg);
				
				System.out.println("Server's response : " + inputStream.readUTF());
				
			}
			
			clientSocket.close();			
						
		} 
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		finally {
			
			userInput.close();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Client_Socket client_Socket = new Client_Socket();
		
		client_Socket.messageToServer();
		
	}
	
}
