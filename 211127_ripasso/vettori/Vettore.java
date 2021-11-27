import java.util.Scanner;

// richiede l'imput di 5 valori interi per inizializzare un vettore.
// Al termine esegue:
// - visualizzazione del vettore.
// - calcolo della media dei valori del vettore.
// - ordinamento in modo crescente del vettore.
// - stampa del vettore.

public class Vettore {
    public static void main(String[] args) {
        int[] vet = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci un numero");
            vet[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("\n--------------------");
        System.out.println("La media e': " + mediaVet(vet) + "\n");
        System.out.println("Prima di sorting:");
        showVet(vet);
        System.out.println("Dopo sorting: ");
        ascendingSort(vet);
        showVet(vet);
    }

    public static void showVet(int[] vet) {
        System.out.print("Vettore: ");
        for (int element : vet) {
            System.out.print(element + " ");
        }
        System.out.println("\n");
    }

    public static float mediaVet(int[] vet) {
        float somma = 0;
        for (int element : vet) {
            somma += element;
        }

        return somma / vet.length;
    }

    public static void ascendingSort(int vet[]) { // insertion sort algorithm
        // int howManyCycles = 0;

        int lenght = vet.length;
        for (int i = 0; i < lenght; i++) {
            int j = i; // per indietreggiare tra le celle
            int element = vet[i];
            while (j - 1 >= 0 && element < vet[j - 1]) {
                vet[j] = vet[j - 1];
                vet[j - 1] = element;
                j--;
                // howManyCycles++;
            }
        }
        // System.out.println(howManyCycles + " cicli eseguiti");
    }
}