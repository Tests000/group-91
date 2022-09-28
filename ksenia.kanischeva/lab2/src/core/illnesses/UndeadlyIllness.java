package core.illnesses;

import core.illnesses.AbstractIllness;

public abstract class UndeadlyIllness extends AbstractIllness {

    public UndeadlyIllness(int damage) {
        super(damage);
    }

    public void leave(int health) {
        health = 100;
        System.out.println("Человек здоров!!");
    }

    @Override
    public String toString(){
        return super.toString() + "несмертельная болезнь - ";
    }
}
