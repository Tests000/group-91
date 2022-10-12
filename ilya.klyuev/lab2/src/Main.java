import classes.ArmorPiercingProjectile;
import classes.Cartridge;
import classes.FragmentationProjectile;
import interfaces.Ammunition;
import interfaces.AntiUSAAmmunition;

import java.util.ArrayList;

public class Main {
    public static void main(final String[] args) {
        var items = getItems();

        for (var item : items) {
            if (item instanceof AntiUSAAmmunition antiUSAAmmunition){
                antiUSAAmmunition.atackUSACity("Вашингтон");
            }
            else{
                item.experience();
            }
            item.disposal();
            System.out.println();
        }
    }

    private static ArrayList<Ammunition> getItems(){
        var items = new ArrayList<Ammunition>();
        items.add(new FragmentationProjectile("BBB", 30, 50));
        items.add(new ArmorPiercingProjectile("BBB", 50, 20));
        items.add(new ArmorPiercingProjectile("AAA-123", 100, 50));
        items.add(new FragmentationProjectile("AD-666", 666, 6666));
        items.add(new Cartridge("AAA-123", 20));
        return items;
    }
}
