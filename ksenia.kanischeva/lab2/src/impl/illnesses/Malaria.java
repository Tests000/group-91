package impl.illnesses;

import core.illnesses.DeadlyIllness;

public class Malaria extends DeadlyIllness {

    private static final int DAMAGE = 10;
    private static final int LIFE_TIME = 6;
    private static final String NAME = "малярия";


    public Malaria() {
        super(DAMAGE, NAME, LIFE_TIME);
    }

    @Override
    public String toString() {
        return super.toString() + NAME;
    }

}
