package Classes;

import java.util.Objects;

public abstract class Bee {
    protected String name;
    protected Integer age;

    public Bee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void fly() {
        System.out.println("Пчела летит");
    }

    public void buzz() {
        System.out.println("Пчела говорит ♪♫♪ Бж-ж-ж ♪♫♪");
    }

    @Override
    public String toString() {
        return "Пчела: " + name + "\nВозраст: " + age + " дней";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bee bee) {
            return name.equals(bee.name) && age.equals(bee.age);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}