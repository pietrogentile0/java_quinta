import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Server{
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3000);
            Socket socket = server.accept();
            System.out.println("Collegato!");
            server.close();

            File csv = new File("csvToSend.txt");
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(csv)));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String row;
            while((row = file.readLine()) != null){
                out.println(row);
            }
            out.println("\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            in.close();
            out.close();
            out.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}