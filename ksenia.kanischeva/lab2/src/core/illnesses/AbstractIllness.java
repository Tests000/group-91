package core.illnesses;

import java.util.Objects;

public abstract class AbstractIllness implements Illness {
    protected final int damage;
    protected final String name;

    public AbstractIllness(int damage, String name) {
        this.damage = damage;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void doBadThing() {
        int health = 100;
        System.out.println("Человек болен!");
        System.out.println(this);
        System.out.println("Я нанесу урон через 3, 2, 1...");
        try {
            while (health > 20) {
                health -= damage;
                System.out.println("Текущее здоровье - " + health + "%");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean equals(Object illness) {
        if (illness instanceof Illness) {
            return name.equals(((Illness) illness).getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(damage, name);
    }

    @Override
    public String toString() {
        return "Привет, я ";
    }
}
