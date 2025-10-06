/**
 * Represents a Student
 */
public class Student extends Person implements Evaluable {
    private String program;
    private int year;
    private double gpa;

    public Student(int id, String name, int age, String program, int year, double gpa) {
        super(id, name, age);
        this.program = program;
        this.year = year;
        this.gpa = gpa;
    }

    // Overloaded constructor
    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a student in " + program + " program, year " + year);
    }

    @Override
    public String evaluatePerformance() {
        if (gpa >= 3.5) return "A";
        else if (gpa >= 3.0) return "B";
        else if (gpa >= 2.0) return "C";
        else return "F";
    }

    @Override
    public String toString() {
        return super.toString() + ", Program: " + program + ", Year: " + year + ", GPA: " + gpa;
    }

    public double getGpa() { return gpa; }
}
