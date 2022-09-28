package impl.illnesses;

import core.illnesses.UndeadlyIllness;

public class Cold extends UndeadlyIllness {

    private static final int DAMAGE = 2;

    public Cold() {
        super(DAMAGE);
    }


    @Override
    public String toString() {
        return super.toString() + "простуда";
    }

}
