package OOP.zookeeperassignment;

public class Mammals {

    private int energy = 100;

    public Mammals() {
    }

    public Mammals(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void displayEnergy() {
        System.out.println("Energy Is: " + energy);
    }
}
