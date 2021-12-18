import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) {
        final int port = 3000;

        try{
            while(true){
                ServerSocket server = new ServerSocket(port);
                Socket endpoint = server.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(endpoint.getInputStream()));
                String clientMessage;
                while((clientMessage = reader.readLine()) != null){
                    System.out.println(clientMessage);
                }
                server.close();

                Socket serverOut = new Socket("localhost", port);
                PrintWriter writer = new PrintWriter(serverOut.getOutputStream());
                Scanner serverResponse = new Scanner(System.in);
                writer.println(serverResponse.nextLine());
                serverOut.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
}