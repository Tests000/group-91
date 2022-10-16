package impl.illnesses;

import core.illnesses.UndeadlyIllness;

public class Scoliosis extends UndeadlyIllness {

    public Scoliosis() {
        super(3, "сколиоз");
    }

    @Override
    public String toString() {
        return super.toString() + this.getName();
    }
}
