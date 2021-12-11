import java.util.LinkedList;

public class linked {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();

        cars.add("mercedes");
        cars.add("alfa-romeo");
        cars.add("aston-martin");
        cars.add("alpine");

        System.out.println(cars.get(3));

    }
}