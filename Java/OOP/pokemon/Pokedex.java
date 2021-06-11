package OOP.pokemon;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {

    ArrayList<Pokemon> myPokemons = new ArrayList<>();


    public Pokedex() {
    }

    public void listPokemon() {
        for (Pokemon pokemon : myPokemons) {
            System.out.println(pokemonInfo(pokemon));
        }
    }

    public Pokemon addPokemon(String name, String type, int health) {
        Pokemon mypoke = createPokemon(name, health, type);
        myPokemons.add(mypoke);
        System.out.println(String.format("Added Pokemon %s to List Successfully!", name));
        return mypoke;
    }


}
