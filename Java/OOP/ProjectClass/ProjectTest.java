package OOP.ProjectClass;

public class ProjectTest {
    public static void main(String[] args) {
        //Created Portfolio Object
        Portfolio portfolio = new Portfolio();
        //Created a Project
        Project project1 = new Project();
        project1.setName("Yummy");
        project1.setDescription("This is a resturent app");
        project1.setInitialCost(1500.0);
        //Added project to portfolio
        portfolio.addProject(project1);
        //Created a Project
        Project project2 = new Project("Baleh Store", "A Store for Baleh and used stuff");
        project2.setInitialCost(25000.0);
        //Added project to portfolio
        portfolio.addProject(project2);
        //Called Portfolio Print Function
        portfolio.showPortfolio();
    }
}
