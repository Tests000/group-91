public class Salad extends Plant {
    protected int area;

    public Salad(String name, int height, int area) {
        super(name, height);
        this.area = area;
    }
    @Override
    public void grow() {
        area *= 1.2;
        String message = "Растение " + name + " выросло на " + area*0.2;
        System.out.printf(message);
    }

    @Override
    public String toString() {
        return name + "Salad { " +
                "height=" + height +
                ", area =" + area +
                '}';
    }
}
