package core.illnesses;


import java.util.Objects;

public abstract class DeadlyIllness extends AbstractIllness {
    protected final int lifeTime;

    public DeadlyIllness(int damage, String name, int lifeTime) {
        super(damage, name);
        this.lifeTime = lifeTime;
    }

    public void dead() {
        System.out.println("Человек умер...");
    }

    public String getLifeTime() {
        return "Осталось " + lifeTime + " дней...";
    }

    @Override
    public boolean equals(Object illness) {
        if (illness instanceof DeadlyIllness) {
            return lifeTime == ((DeadlyIllness) illness).lifeTime && super.equals(illness);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, damage, lifeTime);
    }

    @Override
    public String toString() {
        return super.toString() + "смертельная болезнь - ";
    }


}
