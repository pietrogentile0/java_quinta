import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;

public class app {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept(); // accept() returns a socket

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String req = readWithBody(in);
            System.out.print(req);

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

    public static String readWithoutBody(BufferedReader in) throws IOException {
        String req = "", temp = "";
        while ((temp = in.readLine()) != null) {
            req = req + temp + "\n";
        }
        return req;
    }

    public static String readWithBody(BufferedReader in) throws IOException {
        String req = readWithoutBody(in), method = "";
        char tempMethod;

        // riconosce il metodo
        // int i = 0;
        // while ((tempMethod = req.charAt(i)) != ' ') {
        // method = method + tempMethod;
        // i++;
        // }

        // cerca il content length
        // if (method != "GET") {
        // BufferedReader reader = new BufferedReader(new StringReader(req));
        // String reqLine = reader.readLine();
        // char tempHeader;

        // i = 0;
        // while ((tempHeader = reqLine.charAt(i)) != ':') {

        // }
        // }
        return req;
    }
}