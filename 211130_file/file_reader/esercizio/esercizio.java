import java.io.*;

public class esercizio {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("../nomi.txt");
        BufferedReader br = new BufferedReader(reader);

        String name;
        try {
            System.out.println("Nomi con A iniziale");
            while ((name = br.readLine()) != null) {
                if (name.charAt(0) == 'a' || name.charAt(0) == 'A') {
                    System.out.println(name);
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
