import java.util.Objects;

public class Lamp extends Tovar implements LampImpl {
    public Lamp(String model, int voltage, int amper, int srokGodnosti, int cost) {
        super(cost, srokGodnosti);
        this.model = model;
        this.voltage = voltage;
        this.amperStrength = amper;
    }

    @Override
    public void build() {
        System.out.println("Вы прикрепили лампу к столу и включили её в розетку!");
    }

    @Override
    public String toString() {
        return "Модель: " + this.model + "\nВольтаж: " + this.voltage + "\nРазрешенная сила тока: " + amperStrength;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lamp))
            return false;

        return this.model.equalsIgnoreCase(((Lamp) obj).model)
                && this.voltage == ((Lamp) obj).voltage
                && this.amperStrength == ((Lamp) obj).amperStrength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, voltage, amperStrength, isOn);
    }

    public void powerLamp() {
        isOn = !isOn;
        String printStr = isOn ? "Лампа включена" : "Лампа отключена";

        System.out.println(printStr);
    }

    private final String model;
    private final int voltage;
    private final int amperStrength;
    private boolean isOn;
}