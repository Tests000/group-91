import java.util.Objects;
public abstract class Plant {
    public final int height;
    protected boolean isNeedWatering = true;
    protected String name;

    public Plant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void water() {
        if (isNeedWatering) {
            isNeedWatering = false;
            System.out.printf("Растение полито %s", name);
        }
    }

    public void Grow() {}

    public boolean isNeedWatering() {
        return isNeedWatering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Plant)) return false;
        Plant plant = (Plant) obj;
        return name.equals(plant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
