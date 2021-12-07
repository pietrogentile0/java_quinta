import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class app {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String msg;
            while((msg = in.readLine()) != null){
                System.out.println(msg);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            out.println("HTTP/1.1 200 OK");
            out.println("Content-type: text/plain");
            out.println("Content-length: 4");
            out.println("\nCiao");
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}