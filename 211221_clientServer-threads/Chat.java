import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        final int port = 3000;
        Socket socket;
        PrintWriter out;
        BufferedReader in;
        String clientMessage;
        String serverMessage;
        Scanner messageReader = new Scanner(System.in);

        try {
            // creazione del socket
            if (args.length > 0 && args[0].equals("server")) {
                ServerSocket server = new ServerSocket(port);
                socket = server.accept();
                server.close(); // non accetta più altre richieste
            } else {
                socket = new Socket("localhost", port);
            }

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            // prima lettura del server
            if (args.length > 0 && args[0].equals("server")) {
                if ((serverMessage = in.readLine()).equals("quit")) {
                    throw new Exception("\n----- Connessione interrotta dall'endpoint -----");
                } else {
                    System.out.println("\t\t\t\t" + serverMessage);
                }
            }

            while (true) {
                clientMessage = messageReader.nextLine();
                out.println(clientMessage);
                out.flush();
                if (clientMessage.equals("quit")) {
                    socket.close();
                    throw new Exception("\n----- Hai interrotto la connessione -----");
                } else {
                    if ((serverMessage = in.readLine()).equals("quit")) {
                        throw new Exception("\n----- Connessione interrotta dall'endpoint -----");
                    } else {
                        System.out.println("\t\t\t\t" + serverMessage);
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("\n----- Hai interrotto forzatamente la connessione -----");
        } catch (ConnectException e) {
            System.out.println("\n----- Impossibile connettersi all'endpoint -----");
        } catch (SocketException e) {
            System.out.println(e);
            System.out.println("\n----- Connessione interrotta forzatamente dal server -----");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            messageReader.close();
        }

        // public static String readSocket(BufferedReader in){
        // return
        // }
    }
}