package classes;

import java.util.Objects;

public class Bear extends Predatory {

    private final int clawSize;
    private final boolean isIntoHibernation;

    public Bear(int clawSize, boolean isIntoHibernation, String animalFamily, int aggression, int countBaby) {
        super(animalFamily, aggression, countBaby);
        this.clawSize = clawSize;
        this.isIntoHibernation = isIntoHibernation;
    }

    @Override
    public void eatingFlesh(){
        System.out.println("Медведь съел рыбу и приступил к мясу\n");
    }

    @Override
    public String toString(){
        return super.toString() + "\nРазмер когтей: " + this.clawSize + " мм; медведь сейчас в спячке: " + this.isIntoHibernation;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        Bear bear = (Bear) ob;

        return this.clawSize == bear.clawSize &&
                Objects.equals(this.isIntoHibernation, bear.isIntoHibernation);
    }

    @Override
    public int hashCode(){
        return Objects.hash(clawSize, isIntoHibernation);
    }
}
