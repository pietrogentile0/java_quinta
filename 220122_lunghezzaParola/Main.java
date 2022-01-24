import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.print("Inserire N: ");
            Scanner keyboard = new Scanner(System.in);
            final int N = keyboard.nextInt();
            try {
                FileWriter fileWriter = new FileWriter("minori.txt");
                // fileReader = new BufferedReader(new InputStreamReader(new
                // FileInputStream(args[0])));
                Scanner fileReader = new Scanner(new File(args[0]));
                String word;
                while (fileReader.hasNext()) {
                    if ((word = fileReader.next()).length() >= N) {
                        System.out.println(word);
                    } else {
                        fileWriter.append(word + "\n");
                    }
                }
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            keyboard.close();
        } else {
            System.out.println("Inserire argomento contenente nome file");
        }
    }
}