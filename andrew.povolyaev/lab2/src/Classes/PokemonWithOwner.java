package Classes;

import Interfaces.Pokemon;

import java.util.Objects;

public class PokemonWithOwner extends PokemonCreature{

    private final String ownerName;
    private final double damageMultiplier;

    public PokemonWithOwner(String ownerName, double damageMultiplier, int id, String name, int damage){
        super(id, name, damage);
        this.ownerName = ownerName;
        if (damageMultiplier > 1.0){
            this.damageMultiplier = damageMultiplier;
        }
        else {
            this.damageMultiplier = 1.0;
        }
    }

    @Override
    public String toString(){
        return super.toString() + "Хозяина зовут " + this.ownerName + ", благодаря нему урон возрастает в " + damageMultiplier + "раз(а).";
    }

    @Override
    public void makeSuperCombo(){
        System.out.println("Невероятная командная атака от " + this.name + " и " + this.ownerName + "!");
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (obj == null || obj.getClass() != getClass()){
            return false;
        }

        PokemonWithOwner pokemon = (PokemonWithOwner) obj;

        return pokemon.id == this.id && pokemon.ownerName == this.ownerName;
    }

    @Override
    public int hashCode(){
        return Objects.hash(ownerName, damageMultiplier);
    }
}
