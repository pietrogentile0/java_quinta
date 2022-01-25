import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Verifica {
    public static void main(String[] args) {
        try {
            // inserimento parola da tastiera
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Inserici una parola: ");
            final int wordFromKeyboardLength = keyboard.readLine().length();
            keyboard.close();

            File vocabolario = new File("Vocabolario.txt");
            if (vocabolario.exists()) {
                String wordFromFile;
                Scanner vocabolarioReader = new Scanner(vocabolario);

                File minori = new File("minori.txt");
                if (!minori.exists())
                    minori.createNewFile();
                PrintWriter minoriWriter = new PrintWriter(minori);

                int differenza;
                while (vocabolarioReader.hasNext()) {
                    wordFromFile = vocabolarioReader.next();

                    differenza = wordFromKeyboardLength - wordFromFile.length();
                    if (differenza > 0) {
                        minoriWriter.println("\"" + wordFromFile + "\" differisce di " + differenza + " caratteri");
                        minoriWriter.flush();
                    }
                }
                minoriWriter.close();
                vocabolarioReader.close();
            } else {
                throw new Exception("File \"Vocabolario.txt\" not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}