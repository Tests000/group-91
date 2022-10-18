public class Salad extends Plant {
    public final int area;

    public Salad(String name, int height, int area) {
        super(name, height);
        this.area = area;
    }

    @Override
    public String toString() {
        return name + "Salad { " +
                "height=" + height +
                ", area =" + area +
                '}';
    }
}
