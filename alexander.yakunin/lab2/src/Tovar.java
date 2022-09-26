public abstract class Tovar implements ProductImpl {
    public Tovar(int cost, int srokGodnosti) {
        this.cost = cost;
        this.srokGodnosti = srokGodnosti;
    }
    public abstract void build();
    public void sale() {
        System.out.println(String.format("Вы купили товар за %d", this.cost));
    }

    public void checkBuyDate() {
        System.out.println(String.format("Срок годности: %d суток", this.srokGodnosti));
    }

    public void throwAway() {
        System.out.println("Вы выкинули товар");
    }

    protected int cost;
    protected int srokGodnosti;
}
