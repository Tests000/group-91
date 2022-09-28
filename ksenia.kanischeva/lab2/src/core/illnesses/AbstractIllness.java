package core.illnesses;

public abstract class AbstractIllness implements Illness {
    private final int damage;

    public AbstractIllness(int damage) {
        this.damage = damage;
    }

    @Override
    public void dealDamage(int health) throws Exception {
        if (health - damage < 0) {
            throw new Exception("Man dead");
        }
        health -= damage;
    }

    @Override
    public String toString() {
       return "Привет, я ";
    }
}
