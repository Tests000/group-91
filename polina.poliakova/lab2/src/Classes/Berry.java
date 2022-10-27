package Classes;

public class Berry extends Plant {
    private int numOfBerries;

    public Berry(String name, int height, int numOfBerries) {
        super(name, height);
        this.numOfBerries = numOfBerries;
    }

    @Override
    public void grow() {
        numOfBerries += 10;
        System.out.printf("Растение " + name + " плодоносит " + numOfBerries);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Plant)) {
            return false;
        }
        Berry berry = (Berry) obj;

        return super.equals(berry) && numOfBerries == berry.numOfBerries;
    }

    @Override
    public String toString() {
        return super.toString() + " Berry { " +
                "number of berries = " + numOfBerries +
                " }";
    }

}
