package BackendAssignment013;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientThreads extends Thread {

	Socket clientSocket;
	
	Scanner userInput = new Scanner(System.in);
	
	public ClientThreads(Socket clientSocket) {
		
		this.clientSocket = clientSocket;
		
	}
	
	
	@Override
	public void run() {
		
		try {
		
			DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
			
			DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
			
			String input;
			 
			 outputStream.writeUTF("Welcome Client.\nWhat's up ?");
			
            while (!(input = inputStream.readUTF()).equalsIgnoreCase("End")) {
			     
				 System.out.println("Client Message : " + input);
			        
			     System.out.println("Enter your reply to the client :");
			        
			     String output = userInput.nextLine();
			       
			     outputStream.writeUTF(output);
			 
			 }
		
		}
		
		catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		finally {
			
			userInput.close();
			
		}
		
	}

}
