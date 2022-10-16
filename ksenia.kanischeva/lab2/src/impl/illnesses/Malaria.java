package impl.illnesses;

import core.illnesses.DeadlyIllness;

public class Malaria extends DeadlyIllness {

    public Malaria() {
        super(10, "малярия", 6);
    }

    @Override
    public String toString() {
        return super.toString() + this.getName();
    }

}
