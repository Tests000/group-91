package Classes;

public class Vegetable extends Plant {
    private int prolificness;

    public Vegetable(String name, int height, int prolificness) {
        super(name, height);
        this.prolificness = prolificness;
    }

    public void aboutPack() {
        System.out.println("Я овощ, принадлежу огороду и горжусь этим!");
    }

    public int getProlificness() {
        return prolificness;
    }

    public void setProlificness(int prolificness) {
        this.prolificness = prolificness;
    }

    @Override
    public final void grow() {
        System.out.printf("Растение " + name + " выросло на " + prolificness);
    }
    @Override
    public String toString() {
        return super.toString() + "Vegetable { prolificness = "
                + prolificness + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Plant)) {
            return false;
        }
        Vegetable vegetable = (Vegetable) obj;

        return super.equals(vegetable) && prolificness == vegetable.prolificness;
    }
}
