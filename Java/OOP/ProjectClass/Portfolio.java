package OOP.ProjectClass;

import java.util.ArrayList;

public class Portfolio {

    private ArrayList<Project> projects = new ArrayList<>();

    public Portfolio() {
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "projects=" + projects +
                '}';
    }

    public double getPortfolioCost() {
        double sum = 0;
        for (Project project : projects) {
            sum += project.getInitialCost();
        }
        return sum;
    }

    public void showPortfolio() {
        System.out.println(String.format("%s ,Total Cost: %.1f", this.toString(), this.getPortfolioCost()));
    }


}
