package classes;

import java.util.Objects;

public class LedLamp extends Lamp {
    private final int countOfLED;

    public LedLamp(String model, int voltage, int amper, int countOfLED, int cost, int srokGodnosti) {
        super(model, voltage, amper, srokGodnosti, cost);
        this.countOfLED = countOfLED;
    }

    public void powerLamp() {
        isOn = !isOn;
        String msg = isOn ? "LED лампа включена" : "Led лампа выключена";

        System.out.println(msg);
    }

    @Override
    public String toString() {
        return super.toString() + "\nКоличество ламп: " + this.countOfLED;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfLED);
    }

    @Override
    public void build() {
        System.out.println("Вы прикрепили LED лампу к столу и включили её в розетку!");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LedLamp)) {
            return false;
        } else {

            LedLamp objLedLamp = (LedLamp) obj;
            return this.model.equalsIgnoreCase(objLedLamp.model)
                    && this.voltage == objLedLamp.voltage
                    && this.amperStrength == objLedLamp.amperStrength
                    && this.countOfLED == (objLedLamp).countOfLED;
        }
    }
}