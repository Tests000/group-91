import java.util.Objects;

public class Shkaf extends Tovar {
    public Shkaf(String model, int countOfPolkas, int srokGodnosti, int cost) {
        super(cost, srokGodnosti);
        this.model = model;
        this.countOfPolkas = countOfPolkas;
    }

    @Override
    public void build() {
        System.out.println("Вы собрали шкаф из нескольких досок!!!");
    }

    @Override
    public String toString() {
        return "Модель: " + this.model + "\nКоличество полок: " + this.countOfPolkas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Shkaf shkaf = (Shkaf) obj;
        return this.model.equalsIgnoreCase(shkaf.model)
                && this.countOfPolkas == shkaf.countOfPolkas
                && this.srokGodnosti == shkaf.srokGodnosti;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, countOfPolkas);
    }

    private final String model;
    private final int countOfPolkas;
}