public class Berry extends Plant {
    protected int numOfBerries;
    public Berry(String name, int height, int numOfBerries) {
        super(name, height);
        this.numOfBerries = numOfBerries;
    }

    @Override
    public void grow() {
        numOfBerries += 10;
    }

    @Override
    public String toString() {
        return name + "Berry { " +
                "height=" + height +
                ", number of berries =" + numOfBerries +
                '}';
    }

}
