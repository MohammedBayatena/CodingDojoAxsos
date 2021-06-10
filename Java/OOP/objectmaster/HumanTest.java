package OOP.objectmaster;

public class HumanTest {

    public static void main(String[] args) {
        Human h1 = new Human();
        Human h2 = new Human();

        h1.displayHealth();
        h2.displayHealth();
        h1.attack(h2);
        h1.attack(h2);
        h1.displayHealth();
        h2.displayHealth();

    }


}
