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
            while (true) {
                Socket socket = serverSocket.accept(); // accept() returns a socket
                System.out.println("----nuova richiesta----");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Request req = parser(in);

                System.out.println(req);

                // RESPONSE
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                FileReader reader;
                switch (req.uri) {
                    case "/contact-us": {
                        reader = new FileReader(".\\responses\\contact-us.html");
                        break;
                    }

                    default: {
                        reader = new FileReader(".\\responses\\home.html");
                        break;
                    }
                }

                BufferedReader br = new BufferedReader(reader);
                String fromFile, res = "";

                while ((fromFile = br.readLine()) != null) {
                    res = res + fromFile + "\n";
                }
                br.close();

                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println("Content-Length:" + res.length() + "\n");
                out.print(res);
                out.flush();
                out.close();
            }
            // socket.close();
            // serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Request parser(BufferedReader in) throws IOException {
        String[] firstLineParts = in.readLine().split(" ");
        String method = firstLineParts[0];
        String uri = firstLineParts[1];

        HashMap<String, String[]> headers = headerParser(in);

        if (headers.containsKey("Content-Length")) {
            String body = null;
            body = bodyParser(in, Integer.parseInt(headers.get("Content-Length")[0]));
            return new Request(method, uri, headers, body); // with body
        }

        return new Request(method, uri, headers); // without body
    }

    public static HashMap<String, String[]> headerParser(BufferedReader in) throws IOException {
        String line = "";

        // 1st -> header name
        // 2nd -> values ArrayList
        HashMap<String, String[]> headers = new HashMap<String, String[]>();
        // per ovviare al problema del != null
        while ((line = in.readLine()).length() != 0) {
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