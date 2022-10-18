public class Main {
    public static void main(String[] args) {
        Plant[] plants = new Plant[2];
        plants[0] = new Vegetable("Tomato", 40, 70);
        plants[1] = new Salad("Fennel", 10, 400);
       // plants[2] = new VacuumBot(3, 5, 200);

        for (Plant plant : plants) {
            System.out.println(plant);
            plant.water();
            System.out.println();
        }
        System.out.println();

        Vegetable cucumber = new Vegetable("Cucumber", 30,60);
        System.out.println(cucumber);
        System.out.println("Сравниваем объекты tomato и cucumber: " + plants[0].equals(cucumber));
        System.out.println("Hash-код огурца: " + cucumber.hashCode());
    }
}