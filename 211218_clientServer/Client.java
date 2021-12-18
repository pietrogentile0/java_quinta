import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        final int port = 3000;

        try{
            while(true){
                Socket serverOut = new Socket("localhost", port);
                PrintWriter writer = new PrintWriter(serverOut.getOutputStream(), true);
                Scanner clientMessage = new Scanner(System.in);
                writer.println(clientMessage.nextLine());
                writer.flush();
                writer.close();
                serverOut.close();
                
                ServerSocket socket = new ServerSocket(port);
                Socket serverIn = socket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(serverIn.getInputStream()));
                String responseFromServer;
                while((responseFromServer = reader.readLine()).length() > 0){
                    System.out.println(responseFromServer);
                }
                socket.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
}