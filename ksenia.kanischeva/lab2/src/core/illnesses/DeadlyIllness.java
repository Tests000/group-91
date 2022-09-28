package core.illnesses;

import core.illnesses.AbstractIllness;

public abstract class DeadlyIllness extends AbstractIllness {

    private final int lifeTime;

    public DeadlyIllness(int damage, int lifeTime) {
        super(damage);
        this.lifeTime = lifeTime;
    }

    public void printLifeTime() {
        System.out.println("Осталось " + lifeTime + "дней");
    }


    @Override
    public String toString(){
        return super.toString() + "смертельная болезнь - ";
    }

}
