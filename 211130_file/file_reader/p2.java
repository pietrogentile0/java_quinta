import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class p2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("nomi.txt");
        BufferedReader br = new BufferedReader(reader);

        String name;
        try {
            while ((name = br.readLine()) != null) {
                System.out.println(name);
            }

            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
