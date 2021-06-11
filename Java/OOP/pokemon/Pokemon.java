package OOP.pokemon;

public class Pokemon {

    protected String name, type;
    protected int health;
    protected int amount = 10;
    public static int count = 0;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Pokemon() {
        count++;
    }

    public Pokemon(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void reduceHealth(int amount) {
        setHealth(getHealth() - amount);
    }

    public void addHealth(int amount) {
        setHealth(getHealth() + amount);
    }

    public void attackPokemon(Pokemon enemy) {

        System.out.println(String.format("%s Attacked %s and deducted %d from it's health", this.getName(), enemy.getName(), this.getAmount()));

        enemy.reduceHealth(getAmount());
    }


}
