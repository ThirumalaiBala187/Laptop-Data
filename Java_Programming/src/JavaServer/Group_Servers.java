package JavaServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Group_Servers {

	public Group_Servers() {
		// TODO Auto-generated constructor stub
	}


    private int portNumber;

    Group_Servers(int portNumber){
        this.portNumber=portNumber;

    }

void startServer(){

try{
    ServerSocket server=new ServerSocket(portNumber);

while(true){
    Socket client =server.accept();
    ClientThread clientThread=new ClientThread(client);
    clientThread.start();

}
}
catch(Exception e){
    System.out.println(e.getMessage());
}

}
	
    public static void main(String[] args) {
        
        Group_Servers s=new Group_Servers(1242);
        s.startServer();

    }
    
}

class ClientThread extends Thread{
 Socket client;

ClientThread(Socket client){
    this.client=client;
}

public void run(){
	try{
		Scanner serverOutput = new Scanner(System.in);
	    DataInputStream in =new DataInputStream(client.getInputStream());
	    DataOutputStream out=new DataOutputStream(client.getOutputStream());
	
	    String input ="";
		while(!input.equalsIgnoreCase("End")){
			System.out.println("\nEnter your message to the client :");  
			String outputString = serverOutput.nextLine();              
			out.writeUTF(outputString);
			input = in.readUTF();
			System.out.println("Client Message : " + input);
		}
		System.out.println("Client disconnected");
		System.out.println("Server closed");
		serverOutput.close();	  
	}
	
	catch(Exception e){
	    System.out.println(e.getMessage());
	}
}

}