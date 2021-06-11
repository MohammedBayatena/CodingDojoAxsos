package OOP.pokemon;

public class PokemonTest {

    public static void main(String[] args) {
        Pokemon poke1, poke2, poke3;
        Pokedex dex = new Pokedex();
        System.out.println("__Creation Testing__\n");
        poke1 = dex.addPokemon("Pikachu", "Electric", 100);
        poke2 = dex.addPokemon("Turtle", "Water", 100);
        poke3 = dex.addPokemon("Dino", "Fire", 200);
        System.out.println("\n__Attacks Testing__");
        poke1.attackPokemon(poke2);
        poke1.attackPokemon(poke2);
        poke2.attackPokemon(poke1);
        System.out.println("\n__Info Testing__");
        dex.listPokemon();
        System.out.println("\nSuccess!");


    }


}
