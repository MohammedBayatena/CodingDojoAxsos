package OOP.objectmaster;

public class Samurai extends Human {

    private static int counter = 0;

    public Samurai() {
        super(3, 3, 3, 200);
        counter++;
    }

    public void deathBlow(Human enemy) {
        enemy.die();
        this.reduceHealth(this.getHealth() / 2);
    }

    public void meditate() {
        this.setHealth(200);
    }

    public static int getCounter() {
        return counter;
    }

    public void howMany() {
        System.out.println(String.format("There are %d Samurais Created!", getCounter()));
    }

    @Override
    public void displayHealth() {
        System.out.println("Health is at: " + this.getHealth() + "/" + 200);
    }
}
