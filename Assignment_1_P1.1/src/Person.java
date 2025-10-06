/**
 * Course: MAD204-01 Java Development for MA
 * Assignment 1 – Part A
 * Name: [Your Name]
 * Student ID: [Your ID]
 * Date: [Submission Date]
 * Description: Abstract class representing a Person
 */
public abstract class Person {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /** Abstract method for subclasses to introduce themselves */
    public abstract void introduce();

    /** Increases the person's age by 1 */
    public void celebrateBirthday() {
        age++;
        System.out.println("Happy Birthday! " + name + " is now " + age + " years old.");
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
