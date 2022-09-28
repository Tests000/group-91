package impl.illnesses;

import core.illnesses.DeadlyIllness;

public class Malaria extends DeadlyIllness {

    private static final int DAMAGE = 7;
    private static final int LIFE_TIME = 30;


    public Malaria() {
        super(DAMAGE, LIFE_TIME);
    }

    @Override
    public String toString() {
        return super.toString() + "малярия";
    }

}
