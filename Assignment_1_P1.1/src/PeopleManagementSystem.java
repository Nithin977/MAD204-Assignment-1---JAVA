import java.util.*;
import java.io.*;

/**
 * Main class for People Management System
 */
public class PeopleManagementSystem {
    private ArrayList<Person> people;
    private Scanner scanner;

    public PeopleManagementSystem() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadPeople(); // Load from file if exists
    }

    /** Displays the main menu and handles user input */
    public void menu() {
        while (true) {
            System.out.println("\n=== People Management System ===");
            System.out.println("1. Add Person");
            System.out.println("2. List People");
            System.out.println("3. Search Person by ID");
            System.out.println("4. Search Person by Name");
            System.out.println("5. Remove Person");
            System.out.println("6. Celebrate Birthday");
            System.out.println("7. Show Performance Evaluation");
            System.out.println("8. Run Countdown (Recursion Demo)");
            System.out.println("9. Save & Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addPerson();
                    case 2 -> listPeople();
                    case 3 -> searchById();
                    case 4 -> searchByName();
                    case 5 -> removePerson();
                    case 6 -> celebrateBirthday();
                    case 7 -> showPerformance();
                    case 8 -> countdownDemo();
                    case 9 -> { savePeople(); System.exit(0); }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }
    }

    /** Adds a new person based on user input */
    private void addPerson() {
        System.out.println("1. Student 2. Professor 3. TA");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter ID: "); int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Age: "); int age = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1 -> {
                System.out.print("Program: "); String program = scanner.nextLine();
                System.out.print("Year: "); int year = Integer.parseInt(scanner.nextLine());
                System.out.print("GPA: "); double gpa = Double.parseDouble(scanner.nextLine());
                people.add(new Student(id, name, age, program, year, gpa));
            }
            case 2 -> {
                System.out.print("Department: "); String dept = scanner.nextLine();
                System.out.print("Title: "); String title = scanner.nextLine();
                System.out.print("Courses Taught: "); int courses = Integer.parseInt(scanner.nextLine());
                people.add(new Professor(id, name, age, dept, title, courses));
            }
            case 3 -> {
                System.out.print("Program: "); String program = scanner.nextLine();
                System.out.print("Year: "); int year = Integer.parseInt(scanner.nextLine());
                System.out.print("GPA: "); double gpa = Double.parseDouble(scanner.nextLine());
                System.out.print("Assigned Course: "); String course = scanner.nextLine();
                people.add(new TeachingAssistant(id, name, age, program, year, gpa, course));
            }
        }
        System.out.println("Person added successfully!");
    }

    /** Lists all people */
    private void listPeople() {
        for (Person p : people) System.out.println(p);
    }

    /** Searches person by ID */
    private void searchById() {
        System.out.print("Enter ID: "); int id = Integer.parseInt(scanner.nextLine());
        Person p = search(id);
        System.out.println(p != null ? p : "Person not found!");
    }

    /** Searches person by name */
    private void searchByName() {
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        ArrayList<Person> results = search(name);
        if (results.isEmpty()) System.out.println("Person not found!");
        else results.forEach(System.out::println);
    }

    /** Removes person by ID */
    private void removePerson() {
        System.out.print("Enter ID to remove: "); int id = Integer.parseInt(scanner.nextLine());
        Person p = search(id);
        if (p != null) { people.remove(p); System.out.println("Removed successfully!"); }
        else System.out.println("Person not found!");
    }

    /** Celebrates birthday for person by ID */
    private void celebrateBirthday() {
        System.out.print("Enter ID: "); int id = Integer.parseInt(scanner.nextLine());
        Person p = search(id);
        if (p != null) p.celebrateBirthday();
        else System.out.println("Person not found!");
    }

    /** Displays performance evaluations */
    private void showPerformance() {
        for (Person p : people) {
            if (p instanceof Evaluable e) {
                System.out.println(p.getName() + " Performance: " + e.evaluatePerformance());
            }
        }
    }

    /** Countdown recursion demo */
    private void countdownDemo() {
        System.out.print("Enter number to countdown: "); int n = Integer.parseInt(scanner.nextLine());
        countdown(n);
    }

    private void countdown(int n) {
        if (n <= 0) { System.out.println("Done!"); return; }
        System.out.println(n);
        countdown(n - 1);
    }

    /** Factorial recursion demo */
    private int factorial(int a) {
        return a <= 1 ? 1 : a * factorial(a - 1);
    }

    /** Overloaded search by ID */
    private Person search(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    /** Overloaded search by name */
    private ArrayList<Person> search(String name) {
        ArrayList<Person> results = new ArrayList<>();
        for (Person p : people) if (p.getName().equalsIgnoreCase(name)) results.add(p);
        return results;
    }

    /** Saves all people to file */
    private void savePeople() {
        try (PrintWriter pw = new PrintWriter("people.txt")) {
            for (Person p : people) pw.println(p);
            System.out.println("Data saved!");
        } catch (Exception e) { e.printStackTrace(); }
    }

    /** Loads people from file (basic demo) */
    private void loadPeople() {
        File file = new File("people.txt");
        if (!file.exists()) return;
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                // Placeholder: could parse and recreate objects
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void main(String[] args) {
        PeopleManagementSystem pms = new PeopleManagementSystem();
        pms.menu();
    }
}
