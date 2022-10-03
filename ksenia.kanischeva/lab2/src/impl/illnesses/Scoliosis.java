package impl.illnesses;

import core.illnesses.UndeadlyIllness;

public class Scoliosis extends UndeadlyIllness {

    private static final int DAMAGE = 3;
    private static final String NAME = "сколиоз";

    public Scoliosis() {
        super(DAMAGE, NAME);
    }

    @Override
    public String toString(){
        return super.toString() + NAME;
    }
}
