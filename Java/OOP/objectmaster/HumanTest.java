package OOP.objectmaster;

public class HumanTest {

    public static void main(String[] args) {

        //Part 1

        System.out.println("-Part 1 Testing-");
        Human h1 = new Human();
        Human h2 = new Human();
        h1.displayHealth();
        h2.displayHealth();
        h1.attack(h2);
        h1.attack(h2);
        h1.displayHealth();
        h2.displayHealth();

        // Part 2

        Wizard z1 = new Wizard();
        Ninja n1 = new Ninja();
        Samurai s1 = new Samurai();
        Samurai s2 = new Samurai();
        Samurai s3 = new Samurai();
        Human dum = new Human();

        //Samurai Testing
        System.out.println("-Samurai Testing-");
        s1.deathBlow(dum);
        dum.displayHealth();
        s1.displayHealth();
        s1.meditate();
        s1.displayHealth();
        s1.howMany();

        //Ninja Testing
        System.out.println("-Ninja Testing-");
        dum.setHealth(100);
        n1.steal(dum);
        dum.displayHealth();
        n1.displayHealth();
        n1.runAway();
        n1.displayHealth();

        //Wizard Testing
        System.out.println("-Wizard Testing-");
        dum.setHealth(100);
        z1.fireBall(dum);
        dum.displayHealth();
        z1.heal(dum);
        dum.displayHealth();


    }


}
