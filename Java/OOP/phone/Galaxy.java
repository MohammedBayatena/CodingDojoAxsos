package OOP.phone;

public class Galaxy extends Phone implements Ringable {

    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return String.format("Galaxy %s says %s", getVersionNumber(), getRingTone());
    }

    @Override
    public String unlock() {
        return ("Unlocking Via finger print");
    }

    @Override
    public void displayInfo() {
        System.out.println(String.format("Galaxy %s from %s", getVersionNumber(), getCarrier()));
    }
}
