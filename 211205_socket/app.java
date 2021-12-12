import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class app {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept(); // accept() returns a socket

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String req = "";

            // works without body
            // while ((req = in.readLine()).length() != 0) {
            // System.out.println(req);
            // }

            // have to work if there's a body
            boolean isOneHead = false;
            while ((req = in.readLine()) != "" || !isOneHead) { // the order is important
                System.out.println(req);
                isOneHead = (req == "") ? true : false;
            }

            FileReader reader = new FileReader("htmlResponse.html");
            BufferedReader br = new BufferedReader(reader);
            String fromFile, res = "";

            while ((fromFile = br.readLine()) != null) {
                res = res + fromFile + "\n";
            }
            reader.close();
            br.close();

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length:" + res.length() + "\n");
            out.print(res);

            out.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}