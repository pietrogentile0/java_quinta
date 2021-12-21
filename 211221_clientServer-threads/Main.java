import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        final int port = 3000;

        try {
            Socket socket;
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner clientMessageReader = new Scanner(System.in);
            String clientMessage;
            String serverMessage;

            if (args[0].equals("server")) {
                ServerSocket server = new ServerSocket(port);
                Socket endpoint = server.accept();

                server.close(); // non accetta più altre richieste
            } else {
                socket = new Socket("localhost", port);
            }
// da sistemare
            while (true) {
                // manda la risposta in ogni caso. poi il server agirà in base al messaggio
                clientMessage = clientMessageReader.nextLine();
                out.println(clientMessage);
                out.flush();
                if (clientMessage.equals("quit")) {
                    System.out.println("\n----- Hai interrotto la connessione -----");
                    socket.close();
                    break;
                } else {
                    if ((serverMessage = in.readLine()).equals("quit")) {
                        System.out.println("\n----- Connessione interrotta dal server -----");
                        break;
                    } else {
                        System.out.println("\t\t\t\t" + serverMessage);
                    }
                }
            }
            in.close();
            out.close();
            clientMessageReader.close();
        } catch (NoSuchElementException e) {
            System.out.println("\n----- Hai interrotto forzatamente la connessione -----");
        } catch (SocketException e) {
            System.out.println("\n----- Connessione interrotta forzatamente dal server -----");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}