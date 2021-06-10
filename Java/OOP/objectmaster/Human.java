package OOP.objectmaster;

public class Human {

    private int strength, intelligence, stealth, health;

    public Human() {
        this.strength = 3;
        this.intelligence = 3;
        this.stealth = 3;
        this.health = 100;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(Human human) {

        human.setHealth(human.getHealth() - this.strength);

    }

    public void displayHealth() {
        System.out.println("Health is at: " + this.health + "/" + 100);
    }


}
