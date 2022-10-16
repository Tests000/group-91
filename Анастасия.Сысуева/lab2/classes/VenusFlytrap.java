package classes;

import java.util.Objects;

public class VenusFlytrap extends Insectivores {

    private final int trapHairLength;
    private final int trapClosingSpeed;

    public VenusFlytrap(int trapHairLength, int trapClosingSpeed, String trapType, int height) {
        super(trapType, height);
        this.trapHairLength = trapHairLength;
        this.trapClosingSpeed = trapClosingSpeed;
    }

    @Override
    public void waitingInsect(){
        System.out.println("Венерина мухоловка выпустила нектар и поджидает насекомых\n");
    }

    @Override
    public String toString(){
        return super.toString() + "\nРазмер длины волоска ловушки: " + this.trapHairLength + " мм; скорость захлопывания ловушки: "
                + this.trapClosingSpeed + " мс";
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        VenusFlytrap vf = (VenusFlytrap) ob;

        return this.trapHairLength == vf.trapHairLength &&
                this.trapClosingSpeed == vf.trapClosingSpeed;
    }

    @Override
    public int hashCode(){
        return Objects.hash(trapHairLength, trapClosingSpeed);
    }
}
