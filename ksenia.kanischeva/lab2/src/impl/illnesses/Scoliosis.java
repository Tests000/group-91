package impl.illnesses;

import core.illnesses.UndeadlyIllness;

public class Scoliosis extends UndeadlyIllness {

    private static final int DAMAGE = 1;

    public Scoliosis() {
        super(DAMAGE);
    }

    @Override
    public String toString(){
        return super.toString() + "сколиоз";
    }
}
