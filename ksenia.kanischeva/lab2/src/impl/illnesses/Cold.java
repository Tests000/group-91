package impl.illnesses;

import core.illnesses.UndeadlyIllness;

public class Cold extends UndeadlyIllness {

    public Cold() {
        super(4, "простуда");
    }

    @Override
    public String toString() {
        return super.toString() + this.getName();
    }


}
