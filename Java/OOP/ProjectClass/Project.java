package OOP.ProjectClass;

public class Project {

    protected String name;
    protected String description;
    protected double initialCost;

    public double getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" + elevatorPitch() + '}';
    }

    public String elevatorPitch() {

        return this.getName() + String.format(" (%.1f) ", this.initialCost) + ": " + this.getDescription();
    }

}
