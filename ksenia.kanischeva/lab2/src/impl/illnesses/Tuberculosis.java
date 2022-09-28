package impl.illnesses;

import core.illnesses.DeadlyIllness;

public class Tuberculosis extends DeadlyIllness {

    private static final int DAMAGE = 6;
    private static final int LIFE_TIME = 44;

    public Tuberculosis() {
        super(DAMAGE, LIFE_TIME);
    }

    @Override
    public String toString() {
        return super.toString() + "туберкулёз";
    }
}
