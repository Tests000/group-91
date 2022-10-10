import classes.Good;
import classes.Lamp;
import classes.LedLamp;
import classes.Shkaf;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Good shkaf1 = new Shkaf("IKEA шкаф", 3, 365, 10000);
        Good shkaf2 = new Shkaf("IKEA шкаф", 3, 365, 10000);
        Good shkaf3 = new Shkaf("IKEA шкаф", 3, 367, 11000);

        Good lampa = new Lamp("Brighter", 230, 2, 366, 5000);
        Good ledLamp = new LedLamp("Mega", 230, 3, 3, 5000, 365);

        List<Good> tovars = new ArrayList<>();
        tovars.add(shkaf1);
        tovars.add(shkaf2);
        tovars.add(shkaf3);
        tovars.add(lampa);
        tovars.add(ledLamp);

        for (Good tovar : tovars) {
            tovar.sale();
            System.out.println();
            tovar.build();
            System.out.println();


            if (tovar instanceof LedLamp lamp) {
                lamp.powerLamp();
                System.out.println();
            }
        }
    }
}