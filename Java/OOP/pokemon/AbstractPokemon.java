package OOP.pokemon;

public abstract class AbstractPokemon implements PokemonInterface {

    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon newpoke = new Pokemon(name, type, health);
        return newpoke;
    }

    public String pokemonInfo(Pokemon pokemon) {
        String info = String.format("{ Type : %s , Name: %s , Health: %s }", pokemon.getType(), pokemon.getName(), pokemon.getHealth());
        return info;
    }


}
