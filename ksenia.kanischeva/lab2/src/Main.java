import core.factory.Factory;
import core.illnesses.AbstractIllness;
import core.illnesses.DeadlyIllness;
import core.illnesses.UndeadlyIllness;
import impl.factory.FactoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Factory factory = new FactoryImpl();

        final List<AbstractIllness> illnesses = factory.getList();

        illnesses.forEach(ill -> {
            ill.doBadThing();
            if (ill instanceof DeadlyIllness) {
                var message = ((DeadlyIllness) ill).getLifeTime();
                System.out.println(message);
                ((DeadlyIllness) ill).dead();
            }

            if (ill instanceof UndeadlyIllness) {
                var message = ((UndeadlyIllness) ill).getGoodNews();
                System.out.println(message);
                ((UndeadlyIllness) ill).leave();
            }


            System.out.println("------------------");

        });


    }
}
