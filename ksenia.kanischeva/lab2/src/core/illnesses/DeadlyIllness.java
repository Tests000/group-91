package core.illnesses;

import core.illnesses.AbstractIllness;

public abstract class DeadlyIllness extends AbstractIllness {

    private final int lifeTime;

    public DeadlyIllness(int damage,String name, int lifeTime) {
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
    public String toString(){
        return super.toString() + "смертельная болезнь - ";
    }


}
