import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Tovar shkaf1 = new Shkaf("IKEA шкаф", 3, 365, 10000);
        Tovar shkaf2 = new Shkaf("IKEA шкаф", 3, 365, 10000);
        Tovar shkaf3 = new Shkaf("IKEA шкаф", 3, 367, 11000);

        Tovar lampa = new Lamp("Brighter", 230, 2, 366, 5000);
        Tovar ledLamp = new LedLamp("Mega", 230, 3, 3);

        ArrayList<Tovar> tovars = new ArrayList<Tovar>();
        tovars.add(shkaf1);
        tovars.add(shkaf2);
        tovars.add(shkaf3);
        tovars.add(lampa);
        tovars.add(ledLamp);

        for (Tovar tovar : tovars) {
            tovar.sale();
            System.out.println();
            tovar.build();
            System.out.println();


            if(tovar instanceof LedLamp lamp) {
                lamp.powerLamp();
                System.out.println();
            }
        }
    }
}