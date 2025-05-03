package  JavaServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_Server {
	
    void sendMessage(){

        Scanner scanner = new Scanner(System.in);

        try {
            int portNumber = 4000;
            Socket client = new Socket("172.17.60.83",portNumber);

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("Client server\nClient server running on port : " + portNumber);

            String content = "";

            while (!content.equalsIgnoreCase("End")) {
                System.out.println("\nPlease Enter your message to the server :");
                content = scanner.nextLine();
                out.writeUTF(content);
                System.out.println("Server response : " + in.readUTF());
            }
            client.close();

        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();


    }

    public static void main(String[] args) {
        Client_Server clientSample = new Client_Server();
        clientSample.sendMessage();
    }

}