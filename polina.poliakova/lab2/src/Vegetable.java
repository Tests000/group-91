public class Vegetable extends Plant {
    private int prolificness;

    public Vegetable(String name, int height, int prolificness) {
        super(name, height);
        this.prolificness = prolificness;
    }


    @Override
    public String toString() {
        return name + " Vegetable { " +
                "height=" + height +
                ", prolificness=" + prolificness +
                " }";
    }

    @Override
    public final void Grow(){
        String message = "Растение" + name+ "выросло на " + prolificness;
        System.out.printf(message);
    }

    public int getProlificness() {
        return prolificness;
    }

    public void setProlificness(int prolificness) {
        this.prolificness = prolificness;
    }
}
