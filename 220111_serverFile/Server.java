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
            ServerSocket server = new ServerSocket(23000);
            Socket socket = server.accept();

            server.close();

            File csv = new File("csvToSend.txt");
            System.out.println("accett");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(csv)));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String row;
            while((row = in.readLine()) != null){
                out.println(row);
            }
            in.close();
            out.close();
            out.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}