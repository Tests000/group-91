package Classes;

public class Salad extends Plant {
    private int area;

    public Salad(String name, int height, int area) {
        super(name, height);
        this.area = area;
    }

    @Override
    public void grow() {
        area *= 1.2;
        System.out.printf("Растение " + name + " выросло на " + area * 0.2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof Plant)) { return false; }
        Salad salad = (Salad) obj;

        return super.equals(salad) && area == salad.area;
    }

    @Override
    public String toString() {
        return super.toString() + "Salad { area = " +
                area + " }";
    }
}
