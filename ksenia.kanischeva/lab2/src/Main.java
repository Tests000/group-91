import core.factory.Factory;
import core.illnesses.AbstractIllness;
import impl.factory.FactoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Factory factory = new FactoryImpl();

        final List<AbstractIllness> illnesses = factory.getList();

        illnesses.forEach(ill -> System.out.println(ill.toString()));

    }
}
