package OOP.zookeeperassignment;

public class Gorilla extends Mammals {


    public Gorilla() {
        super();
    }

    public void eatBananas() {
        System.out.println("Eat Bananas Life Good!");
        setEnergy(getEnergy() + 10);
    }

    public void throwSomething() {
        System.out.println("Angry gorilla ima throw stuff at ya");
        setEnergy(getEnergy() - 5);
    }

    public void climb() {
        System.out.println("Gorilla Climbed a Tree and fell down!");
        setEnergy(getEnergy() - 10);
    }


}
