import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.File;

public class app {
    public static void main(String[] args) {
        File file = new File("text.txt");
        
        try{
            PrintWriter out = new PrintWriter(file);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String word;
            while(!(word = in.readLine()).equals("stop")){
                out.println(word);
            }
            in.close();
            out.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}