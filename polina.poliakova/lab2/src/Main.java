import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Plant tomato = new Vegetable("Tomato", 40, 70);
        Plant fennel = new Salad("Fennel", 10, 400);
        Plant cherry = new Berry("Cherry", 200, 50);

        List<Plant> plants = new ArrayList<>();
        plants.add(tomato);
        plants.add(fennel);
        plants.add(cherry);

        for (Plant plant : plants) {
            System.out.println(plant);
            plant.water();
            System.out.println();
            plant.grow();
            System.out.println();
        }
        System.out.println();

        Vegetable cucumber = new Vegetable("Cucumber", 30,60);
        System.out.println(cucumber);
        System.out.println("Сравниваем объекты tomato и cucumber: " + tomato.equals(cucumber));
        System.out.println("Hash-код огурца: " + cucumber.hashCode());
    }
}