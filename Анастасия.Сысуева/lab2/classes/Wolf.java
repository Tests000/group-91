package classes;

import java.util.Objects;

public class Wolf extends Predatory {
    private final int packSize;
    private final boolean isTheLider;

    public Wolf(int packSize, boolean isTheLider, String animalFamily, int aggression, int countBaby) {
        super(animalFamily, aggression, countBaby);
        this.packSize = packSize;
        this.isTheLider = isTheLider;
    }

    public void aboutPack(){
        System.out.println("Я волк и состаю в стае");
    }

    @Override
    public void eatingFlesh(){
        System.out.println("Волк ест мясо, которое ему принесли\n");
    }

    @Override
    public String toString(){
        return super.toString() + "\nРазмер стаи: " + this.packSize + "; волк является лидером: " + this.isTheLider;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        Wolf wolf = (Wolf) ob;

        return this.packSize == wolf.packSize &&
                Objects.equals(this.isTheLider, wolf.isTheLider);
    }

    @Override
    public int hashCode(){
        return Objects.hash(packSize, isTheLider);
    }
}
