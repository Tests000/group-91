public class Program {
    public static void main(String[] args) {
        Tovar shkaf1 = new Shkaf("IKEA шкаф", 3, 365, 10000);
        Tovar shkaf2 = new Shkaf("IKEA шкаф", 3, 365, 10000);
        Tovar shkaf3 = new Shkaf("IKEA шкаф", 3, 367, 11000);

        shkaf1.build();
        System.out.println(shkaf1);
        System.out.println();

        System.out.println("shkaf1 == shkaf2: " + shkaf1.equals(shkaf2));
        System.out.println("shkaf1 == shkaf3: " + shkaf1.equals(shkaf3));
        System.out.println();

        Tovar lampa = new Lamp("Brighter", 230, 2, 366, 5000);
        lampa.build();
        System.out.println(lampa);
        System.out.println();

        Tovar mega = new MegaLamp("Mega", 230, 3, 3, 12000, 700);
        mega.sale();
        mega.checkBuyDate();
        System.out.println(mega);
        mega.throwAway();
    }
}
