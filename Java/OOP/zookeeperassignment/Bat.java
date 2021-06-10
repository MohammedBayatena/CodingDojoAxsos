package OOP.zookeeperassignment;

public class Bat extends Mammals {

    public Bat() {
        super(300);
    }

    public void fly() {
        System.out.println("Flutter! Flap!");
        setEnergy(getEnergy() - 50);
    }

    public void eatHumans() {
        System.out.println("Aaaaaaaaah!");
        setEnergy(getEnergy() + 25);
    }

    public void attackTown() {
        System.out.println("Aaaaaaaaah! Help! bloody hell wtf! Ahh");
        setEnergy(getEnergy() - 100);
    }

}
