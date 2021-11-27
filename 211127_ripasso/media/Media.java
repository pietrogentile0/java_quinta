// Realizzare un programma Java che richiede l'inserimento di 5 valori interi,
// al termine dell'inserimento visualizza la somma totale e il valore minore inserito.

import java.util.Scanner;

public class Media {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int somma = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci un numero");
            somma += scanner.nextInt();
        }

        System.out.println("La somma totale e' " + somma);
        System.out.println("La media e' " + somma / 5);

        scanner.close();
    }
}