package impl.illnesses;

import core.illnesses.Illness;
import core.illnesses.UndeadlyIllness;

public class Cold extends UndeadlyIllness {

    private static final int DAMAGE = 4;
    private static final String NAME = "простуда";

    public Cold() {
        super(DAMAGE, NAME);
    }


    @Override
    public String toString() {
        return super.toString() + NAME;
    }




}
