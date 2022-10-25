package Classes;

import Interfaces.AbleFertilize;

public class DroneBee extends Bee implements AbleFertilize {

    public Integer numberOfFertilization;

    public DroneBee(String name, int age, int numberOfFertilization) {
        super(name, age);
        this.numberOfFertilization = numberOfFertilization;
    }

    @Override
    public void fertilize() {
        numberOfFertilization++;
        System.out.println("Трутень " + name + " осеменил матку");
    }

    @Override
    public void fly() {
        System.out.println("Трутень " + name + " летит");
    }

    @Override
    public void buzz() {
        System.out.println("Трутень " + name + " говорит ♪♫♪ Бж-ж-ж ♪♫♪");
    }

    @Override
    public String toString(){
        return super.toString() + "\nЧисло оплодотворений: " + numberOfFertilization;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DroneBee droneBee) {
            return super.equals(obj) && numberOfFertilization.equals(droneBee.numberOfFertilization);
        }
        return false;
    }
}
