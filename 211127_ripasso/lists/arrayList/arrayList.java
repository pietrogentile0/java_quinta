import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();

        cars.add("opel");
        cars.add("fiat");
        cars.add("volvo");
        cars.add("ferrari");

        for (String car : cars) {
            System.out.println(car);
        }
        System.out.println(cars.size());
    }
}