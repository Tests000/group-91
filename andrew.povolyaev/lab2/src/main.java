import Classes.PersonChampion;
import Classes.PersonLoser;
import Classes.PersonCreature;
import Classes.PokemonWithoutOwner;
import Classes.PokemonWithOwner;
import Classes.PokemonCreature;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        PersonCreature Ash = new PersonChampion(10, 100000, "Ash", 123, 2);
        PersonCreature Andrew = new PersonLoser(22, 1234, "Andrew", 1, 100);
        PersonCreature Bob = new PersonChampion(15, 45678, "Bob", 45, 3);

        PokemonCreature Pikachu = new PokemonWithOwner("Ash", 3, 1, "Pikachu", 100);
        PokemonCreature Dragon = new PokemonWithoutOwner("Baikal", 3, 15, "qwe", 1000);
        PokemonCreature Myaut = new PokemonWithOwner("R...", 1.5, 9, "Myaut", 10);

        List<PersonCreature> people = new ArrayList<>();
        List<PokemonCreature> pokemons = new ArrayList<>();

        people.add(Ash);
        people.add(Andrew);
        people.add(Bob);

        pokemons.add(Pikachu);
        pokemons.add(Dragon);
        pokemons.add(Myaut);

        System.out.println("Info about people");

        for (PersonCreature person : people) {
            System.out.println(person.toString());
            person.sayHello();
            person.eat();
            if (person instanceof PersonLoser) {
                ((PersonLoser) person).inviteForABattle();
            }
        }

        System.out.println("Info about pokemons");

        for (PokemonCreature pokemon : pokemons) {
            System.out.println(pokemon.toString());
            pokemon.attack();
            pokemon.runAway();
            if (pokemon instanceof PokemonWithOwner) {
                ((PokemonWithOwner) pokemon).makeSuperCombo();
            }
        }
    }
}
