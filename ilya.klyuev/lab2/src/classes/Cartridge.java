package classes;

// патрон
public class Cartridge
        extends AmmunitionImpl {
    // калибр
    private final int caliber;
    public Cartridge(String name, int caliber){
        super(name);
        this.caliber = caliber;
    }
    @Override
    public String toString() {
        return String.format(
                "Патрон %s\n" +
                "Калибр %d\n",
                name,
                caliber
        );
    }

    @Override
    public void experience() {
        showInfo();
        System.out.println("На складе нет автоматов. Использование невозможно\n");
    }
}
