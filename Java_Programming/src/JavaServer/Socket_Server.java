package JavaServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Socket_Server {
	
    private int portNumber;
    Scanner serverOutput = new Scanner(System.in);

    Socket_Server(int portNumber){
        this.portNumber = portNumber;        
    }

//    String[] dynamicResponses = {"Hi!, What's your name?","Welcome, Mathi San!","Have you completed your dinner?","Ohh! Nice.","Your java class today about servers is really nice Mathi san.","Yes Mathi san, Thank you so much for it.","You're Welcome", "Bye, See you tomorrow in our java class Mathi san."};
    public void startServer(){
    	 ServerSocket server = null;
        try {
           server = new ServerSocket(portNumber);
            Socket client = server.accept();
            client.setReuseAddress(true);
            System.out.println("Server Page\nServer Running on port : " + portNumber);

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String input ="";
//            int idx = 0;
            while(!input.equalsIgnoreCase("End")){
                System.out.println("Client Message : " + input);
                System.out.println("\nEnter your message to the client :");                
                out.writeUTF(serverOutput.nextLine());
                input = in.readUTF();
//                idx++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
        	try {
				server.setReuseAddress(true);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//        	try {
//                if (server != null) {
//                    server.close(); // Properly close the server socket
//                    System.out.println("Server socket closed.");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
		}
    }

     public static void main(String[] args) {
        Socket_Server serverSample = new Socket_Server(1280);
        serverSample.startServer();
     }
}