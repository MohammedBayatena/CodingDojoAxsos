package OOP.phone;

public class Iphone extends Phone implements Ringable {

    public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return String.format("Iphone %s says %s", getVersionNumber(), getRingTone());
    }

    @Override
    public String unlock() {
        return ("Unlocking Via facial recognition");
    }

    @Override
    public void displayInfo() {
        System.out.println(String.format("Iphone %s from %s", getVersionNumber(), getCarrier()));
    }
}
