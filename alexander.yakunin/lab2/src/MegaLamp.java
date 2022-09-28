public class MegaLamp extends Lamp {
    public MegaLamp(String model, int voltage, int amper, int countOfLamps, int cost, int srokGodnosti) {
        super(model, voltage, amper, srokGodnosti, cost);
        this.countOfLamps = countOfLamps;
    }

    @Override
    public String toString() {
        return super.toString() + "\nКоличество ламп: " + this.countOfLamps;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.countOfLamps == ((MegaLamp) obj).countOfLamps;
    }


    private int countOfLamps;
}