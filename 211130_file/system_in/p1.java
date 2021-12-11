package system_in;

import java.io.*;

public class p1 {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in); // decorator di un Reader, che legge da uno stream
                                                                 // (System.in)
        BufferedReader br = new BufferedReader(in); // inseriamo l'inputStreamReader in un Buffer che legge fino al
                                                    // prossimo "a capo"
        String string;
        try {
            while ((string = br.readLine()) != null) {
                System.out.println(string);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}