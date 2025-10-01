import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    int marks;

    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
}

public class StudentGradeTracker {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (1-3).");
                continue;
            }

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                viewSummaryReport();
            } else if (choice == 3) {
                System.out.println("Exiting... Thank you!");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Student Grade Tracker ---");
        System.out.println("1. Add Student");
        System.out.println("2. View Summary Report");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty. Student not added.");
            return;
        }

        System.out.print("Enter Roll Number: ");
        int roll;
        try {
            roll = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number. Student not added.");
            return;
        }

        System.out.print("Enter Marks: ");
        int marks;
        try {
            marks = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks. Student not added.");
            return;
        }

        students.add(new Student(name, roll, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewSummaryReport() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }

        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        System.out.println("\n--- Student Report ---");
        for (Student s : students) {
            // print each student
            System.out.println("Name: " + s.name + ", Roll: " + s.rollNumber + ", Marks: " + s.marks);
            total += s.marks;
            if (s.marks > highest) highest = s.marks;
            if (s.marks < lowest) lowest = s.marks;
        }

        double average = (double) total / students.size();
        System.out.printf("%nAverage Marks: %.2f%n", average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
    }
}
