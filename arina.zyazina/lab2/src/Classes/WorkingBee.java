package Classes;

import Interfaces.CollectablePollen;

import java.util.Objects;

public class WorkingBee extends Bee implements CollectablePollen {

    private Integer numberOfFlights;

    public WorkingBee(String name, int age, int numberOfFlights) {
        super(name, age);
        this.numberOfFlights = numberOfFlights;
    }

    @Override
    public void collectPollen() {
        numberOfFlights++;
        System.out.println("Рабочая пчела " + name + " слетала за пыльцой");
    }

    @Override
    public void fly() {
        System.out.println("Рабочая пчела " + name + " летит");
    }

    @Override
    public void buzz() {
        System.out.println("Рабочая пчела " + name + " говорит ♪♫♪ Бж-ж-ж ♪♫♪");
    }

    @Override
    public String toString(){
        return super.toString() + "\nЧисло полетов за пыльцой: " + numberOfFlights;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WorkingBee workingBee) {
            return super.equals(obj) && numberOfFlights.equals(workingBee.numberOfFlights);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, numberOfFlights);
    }
}
