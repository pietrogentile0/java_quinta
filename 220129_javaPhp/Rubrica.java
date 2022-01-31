import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class Rubrica {
    private static String uri;

    public static void setUri(String uri, String name) {
        Rubrica.uri = uri + "?name=" + name;
    }

    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Nome da ricercare: ");
            String name = keyboard.next();
            keyboard.close();

            setUri("http://localhost/5informatica/220129_phpjava/rubrica.php", name);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String telephoneNumber = response.body();
            System.out.println("Numero di telefono corrispondente: " + telephoneNumber);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}