import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("source.txt");
            if (!file.exists())
                file.createNewFile();
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            FileWriter fileWriter = new FileWriter("destination.txt", true);
            String word;
            while ((word = fileReader.readLine()) != null) {
                fileWriter.append(word);
            }
            fileWriter.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}