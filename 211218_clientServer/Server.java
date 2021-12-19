import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final int port = 3000;

        try {
            ServerSocket server = new ServerSocket(port);
            Socket endpoint = server.accept();

            server.close(); // non accetta più altre richieste

            BufferedReader in = new BufferedReader(new InputStreamReader(endpoint.getInputStream()));
            PrintWriter out = new PrintWriter(endpoint.getOutputStream());
            Scanner serverMessageReader = new Scanner(System.in);
            String clientMessage;
            String serverMessage;
            while (true) {
                if ((clientMessage = in.readLine()).equals("quit")) {
                    System.out.println("\n----- Connessione interrotta dal client -----");
                    break;
                } else {
                    System.out.println(clientMessage);

                    // manda la risposta in ogni caso. poi il client agirà in base al messaggio
                    System.out.print("\t\t\t\t");
                    serverMessage = serverMessageReader.nextLine();
                    out.println(serverMessage);
                    out.flush();

                    if (serverMessage.equals("quit")) {
                        System.out.println("\n----- Hai interrotto la connessione -----");
                        endpoint.close();
                        break;
                    }
                }
            }
            in.close();
            out.close();
            serverMessageReader.close();
        } catch (NoSuchElementException e) {
            System.out.println("\n----- Hai interrotto forzatamente la connessione -----");
        } catch (SocketException e) {
            System.out.println("\n----- Connessione interrotta forzatamente dal client -----");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}