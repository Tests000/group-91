import Classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bee queenBee = new QueenBee("Алевтина", 57, 450);
        Bee droneBee1 = new DroneBee("Иннокентий", 20, 5);
        Bee droneBee2 = new DroneBee("Аркадий", 31, 7);
        Bee workingBee1 = new WorkingBee("Евстафий", 42, 32);
        Bee workingBee2 = new WorkingBee("Спиридон", 63, 57);
        Bee workingBee3 = new WorkingBee("Прасковья", 55, 46);
        Bee workingBee4 = new WorkingBee("Агриппина", 25, 21);

        List<Bee> hive = new ArrayList<>();
        hive.add(queenBee);
        hive.add(droneBee1);
        hive.add(droneBee2);
        hive.add(workingBee1);
        hive.add(workingBee2);
        hive.add(workingBee3);
        hive.add(workingBee4);

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
