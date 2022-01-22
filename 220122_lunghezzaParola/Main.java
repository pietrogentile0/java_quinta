import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file;
        if (args.length > 0) {
            file = new File(args[0]);
        }
        System.out.println("Inserire N: ");
        Scanner keyboard = new Scanner(System.in);
        try {
            FileReader fileScanner = new FileReader(file);
            final int N = keyboard.nextInt();
            String word;
            while ((word = ) != null) {
                if (word.length() >= N) {
                    System.out.println(word);

                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}