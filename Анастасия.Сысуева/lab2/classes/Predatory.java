package classes;

import interfaces.Animal;

public abstract class Predatory implements Animal {

    protected String animalFamily;
    protected int aggression;
    protected int countBaby;

    public Predatory(String animalFamily, int aggression, int countBaby){
        this.animalFamily = animalFamily;
        this.aggression = aggression;
        this.countBaby = countBaby;
    }

    public abstract void eatingFlesh();

    public void makeSound(){
        System.out.println("Хищник рычит");
    }

    public void move(){
        if (this.aggression > 50){
            System.out.println("Хищник двигается быстро");
        } else {
            System.out.println("Хищник медленно передвигается");
        }
    }

    public void careOfBaby(){
        if (this.countBaby == 0){
            System.out.println("У хищника нет детенышей");
        } else {
            System.out.printf("Хищник заботится о %d детеныш(е/ах)%n", this.countBaby);
        }
    }
}
