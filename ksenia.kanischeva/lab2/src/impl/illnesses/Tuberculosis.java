package impl.illnesses;

import core.illnesses.DeadlyIllness;

public class Tuberculosis extends DeadlyIllness {

    private static final int DAMAGE = 8;
    private static final int LIFE_TIME = 10;
    private static final String NAME = "туберкулёз";

    public Tuberculosis() {
        super(DAMAGE, NAME, LIFE_TIME);
    }

    @Override
    public String toString() {
        return super.toString() + this.getName();
    }
}
