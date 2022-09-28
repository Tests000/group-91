import java.util.Objects;

public class LedLamp extends Tovar implements LampImpl {
    public LedLamp(String model, int countOfLED, int cost, int srokGodnosti) {
        super(cost, srokGodnosti);
        this.model = model;
        this.countOfLED = countOfLED;
        this.isOn = false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nКоличество ламп: " + this.countOfLED;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, countOfLED, isOn);
    }

    @Override
    public void build() {
        System.out.println("Вы прикрепили LED лампу к столу и включили её в розетку!");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LedLamp))
            return false;

        return this.model.equalsIgnoreCase(((LedLamp) obj).model)
                && this.countOfLED == ((LedLamp) obj).countOfLED;
    }

    public void powerLamp() {
        isOn = !isOn;
        String msg = isOn ? "LED лампа включена" : "Led лампа выключена";

        System.out.println(msg);
    }

    private final String model;
    private final int countOfLED;
    private boolean isOn;
}