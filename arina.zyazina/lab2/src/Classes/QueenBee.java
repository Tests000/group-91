package Classes;

import Interfaces.Birthable;

import java.util.Objects;

public class QueenBee extends Bee implements Birthable {

    private Integer numberOfChildren;

    public QueenBee(String name, int age, int numberOfChildren) {
        super(name, age);
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public void giveBirth() {
        numberOfChildren++;
        System.out.println("Пчелиная матка " + name + " откладывает новое яйцо");
    }

    @Override
    public void fly() {
        System.out.println("Пчелиная матка " + name + " летит");
    }

    @Override
    public void buzz() {
        System.out.println("Пчелиная матка " + name + " говорит ♪♫♪ Бж-ж-ж ♪♫♪");
    }

    @Override
    public String toString(){
        return super.toString() + "\nЧисло детей: " + numberOfChildren;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof QueenBee queenBee) {
            return super.equals(obj) && numberOfChildren.equals(queenBee.numberOfChildren);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, numberOfChildren);
    }
}
