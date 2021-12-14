import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class app {
    public static void main(String[] args) {

        try {
            // REQUEST parse
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept(); // accept() returns a socket

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            parser(in);

            // RESPONSE
            FileReader reader = new FileReader("htmlResponse.html");
            BufferedReader br = new BufferedReader(reader);
            String fromFile, res = "";

            while ((fromFile = br.readLine()) != null) {
                res = res + fromFile + "\n";
            }
            br.close();

            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length:" + res.length() + "\n");
            out.print(res);

            serverSocket.close();
            socket.close(); // chiude tutto
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void parser(BufferedReader in) throws IOException {
        String method = in.readLine().split(" ")[0];

        HashMap<String, String[]> headers = headerParser(in);

        String body = null;
        if (headers.containsKey("Content-Length")) {
            System.out.print("\n");
            body = bodyParser(in, Integer.parseInt(headers.get("Content-Length")[0]));
            System.out.print(body);
        }
    }

    public static HashMap<String, String[]> headerParser(BufferedReader in) throws IOException {
        String line = "";

        // 1st -> header name
        // 2nd -> values ArrayList
        HashMap<String, String[]> headers = new HashMap<String, String[]>();
        // per ovviare al problema del != null
        while ((line = in.readLine()).length() != 0) {
            System.out.println(line);
            String[] parts = line.split(": ");
            headers.put(parts[0], parts[1].split(","));
        }

        return headers;
    }

    public static String bodyParser(BufferedReader in, int bodyLength) throws IOException {
        String body = "";
        for (int i = 0; i < bodyLength; i++) {
            body = body + (char) in.read();
        }
        return body;
    }
}