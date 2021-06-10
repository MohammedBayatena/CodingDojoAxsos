package OOP.objectmaster;

public class Ninja extends Human {
    public Ninja() {
        super(3, 3, 10, 100);
    }

    public void steal(Human enemy) {
        int amount = this.getStealth();
        enemy.reduceHealth(amount);
        this.increaseHealth(amount);
    }

    public void runAway() {
        this.reduceHealth(10);
    }


}
