/**
 * Represents a Professor
 */
public class Professor extends Person implements Evaluable {
    private String department;
    private String title;
    private int coursesTaught;

    public Professor(int id, String name, int age, String department, String title, int coursesTaught) {
        super(id, name, age);
        this.department = department;
        this.title = title;
        this.coursesTaught = coursesTaught;
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I'm Prof. " + name + ", " + title + " in " + department);
    }

    @Override
    public String evaluatePerformance() {
        if (coursesTaught >= 5) return "Excellent";
        else if (coursesTaught >= 3) return "Good";
        else return "Average";
    }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + department + ", Title: " + title + ", Courses Taught: " + coursesTaught;
    }
}
