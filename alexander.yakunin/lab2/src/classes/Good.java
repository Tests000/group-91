package classes;

import interfaces.Product;

public abstract class Good implements Product {

    protected int cost;
    protected int srokGodnosti;

    public Good(int cost, int srokGodnosti) {
        this.cost = cost;
        this.srokGodnosti = srokGodnosti;
    }

    public abstract void build();

    public void sale() {
        System.out.printf("Вы купили товар за %d%n", this.cost);
    }

    public void checkBuyDate() {
        System.out.printf("Срок годности: %d суток%n", this.srokGodnosti);
    }

    public void throwAway() {
        System.out.println("Вы выкинули товар");
    }
}
