import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Rubrica {
    public static void main(String[] args) {
        File csv = new File("./csv.txt");
        LinkedList<Persona> persone = new LinkedList<Persona>();
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(csv)));
            String row;
            while((row = in.readLine()) != null){
                String data[] = row.split(",");
                persone.addLast(new Persona(data[0], data[1], data[2]));
            }
            for(int i = 0; i < persone.size(); i++){
                System.out.println(persone.get(i).toString());
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}