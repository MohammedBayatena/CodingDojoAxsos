package OOP.zookeeperassignment;

public class Gorilla extends Mammals {


    public Gorilla() {
        super();
    }

    public void eatBananas() {
        setEnergy(getEnergy() + 10);
    }

    public void throwSomething() {
        setEnergy(getEnergy() - 5);
    }

    public void climb() {
        setEnergy(getEnergy() - 10);
    }


}
