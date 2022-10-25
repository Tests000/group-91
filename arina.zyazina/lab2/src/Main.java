import Classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bee queenBee = new QueenBee("Алевтина", 57, 450);
        Bee firstDroneBee = new DroneBee("Иннокентий", 20, 5);
        Bee secondDroneBee = new DroneBee("Аркадий", 31, 7);
        Bee firstWorkingBee = new WorkingBee("Евстафий", 42, 32);
        Bee secondWorkingBee = new WorkingBee("Спиридон", 63, 57);
        Bee thirdWorkingBee = new WorkingBee("Прасковья", 55, 46);
        Bee fourthWorkingBee = new WorkingBee("Агриппина", 25, 21);

        List<Bee> hive = new ArrayList<>();
        hive.add(queenBee);
        hive.add(firstDroneBee);
        hive.add(secondDroneBee);
        hive.add(firstWorkingBee);
        hive.add(secondWorkingBee);
        hive.add(thirdWorkingBee);
        hive.add(fourthWorkingBee);

        for (Bee bee: hive) {
            System.out.println(bee.toString());
            bee.fly();
            bee.buzz();

            if (bee instanceof QueenBee) {
                ((QueenBee) bee).giveBirth();
            }

            if (bee instanceof DroneBee) {
                ((DroneBee) bee).fertilize();
            }

            if (bee instanceof WorkingBee) {
                ((WorkingBee) bee).collectPollen();
            }
        }
    }
}
