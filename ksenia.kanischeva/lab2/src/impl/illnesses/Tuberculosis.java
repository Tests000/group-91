package impl.illnesses;

import core.illnesses.DeadlyIllness;

public class Tuberculosis extends DeadlyIllness {

    public Tuberculosis() {
        super(8, "туберкулез", 10);
    }

    @Override
    public String toString() {
        return super.toString() + this.getName();
    }
}
