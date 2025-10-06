/**
 * Represents a Teaching Assistant (TA)
 */
public class TeachingAssistant extends Student {
    private String assignedCourse;

    public TeachingAssistant(int id, String name, int age, String program, int year, double gpa, String assignedCourse) {
        super(id, name, age, program, year, gpa);
        this.assignedCourse = assignedCourse;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm TA " + name + " for " + assignedCourse + ", GPA: " + getGpa());
    }

    @Override
    public String evaluatePerformance() {
        double gpa = getGpa();
        if (gpa >= 3.5) return "Excellent TA";
        else if (gpa >= 3.0) return "Good TA";
        else return "Needs Improvement";
    }

    @Override
    public String toString() {
        return super.toString() + ", Assigned Course: " + assignedCourse;
    }
}
