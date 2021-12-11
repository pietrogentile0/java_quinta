import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class app {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept(); // accept() returns a socket

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String req;
            // while ((req = in.readLine()) != null) {
            // System.out.println(req);
            // }

            for (int i = 0; i < 16; i++) {
                req = in.readLine();
                System.out.println(req);
            }

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain");
            out.println("Content-Length: 4\n");
            out.println("Ciao");

            out.close();

            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}