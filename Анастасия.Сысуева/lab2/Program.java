import classes.Predatory;
import classes.Wolf;
import classes.Bear;
import classes.Insectivores;
import classes.VenusFlytrap;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Predatory wolfVase = new Wolf(5,true, "собачьи", 40, 2);
        Predatory wolfKate = new Wolf(5, false, "собачьи", 15, 4);
        Predatory bearPotap = new Bear(10, false, "медвежьи", 53, 0);

        Insectivores vfSara = new VenusFlytrap(7, 79, "капкан",20);
        Insectivores vfLera = new VenusFlytrap(5, 81, "капкан",13);

        List<Predatory> predatories = new ArrayList<>();
        List<Insectivores> insectivores = new ArrayList<>();
        predatories.add(wolfVase);
        predatories.add(wolfKate);
        predatories.add(bearPotap);

        insectivores.add(vfSara);
        insectivores.add(vfLera);

        System.out.println("В зоопарке находятся растения и животные \nО животных: \n");
        for(Predatory predatory : predatories){
            System.out.println(predatory.toString());
            predatory.makeSound();
            predatory.move();
            predatory.careOfBaby();
            predatory.eatingFlesh();
            if (predatory instanceof Wolf){
                ((Wolf) predatory).aboutPack();
            }
        }
        System.out.println("О растениях: \n");
        for(Insectivores insectivor : insectivores){
            System.out.println(insectivor.toString());
            insectivor.growthUp();
            insectivor.eating();
            insectivor.blossom();
            insectivor.waitingInsect();
        }
    }
}
