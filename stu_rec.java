import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    public Student(int studentID, String name, int age, String department) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getStudentID() { return studentID; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
}

class Studentrec {
    private Student[] students;
    private int count;
    private static final int MAX_STUDENTS = 100;

    public Studentrec() {
        students = new Student[MAX_STUDENTS];
        count = 0;
    }

    public void add_stu(Scanner sc) {
        if (count < MAX_STUDENTS) {
            System.out.println("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.println("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.println("Enter Student Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 
            System.out.println("Enter Student Department: ");
            String department = sc.nextLine();

            students[count] = new Student(id, name, age, department);
            count++;s
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Maximum number of students reached.");
        }
    }

    public void view_rec() {
        if (count == 0) {
            System.out.println("No rec found.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(students[i].getStudentID() + " | " + students[i].getName() + " | " + 
                                   students[i].getAge() + " | " + students[i].getDepartment());
            }
        }
    }

    public void search_rec(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == id) {
                System.out.println("Student found:");
                System.out.println(students[i].getStudentID() + " | " + students[i].getName() + " | " + students[i].getAge() + " | " + students[i].getDepartment());
                return;
            }
        }
        System.out.println("Student not found.");
    }
}

public class stu_rec {
    public static void main(String[] args) {
        Studentrec rec = new Studentrec();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1) Add Student\n2) View All record\n3) Search Student\n4) Exit");
            System.out.print("Enter any: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rec.add_stu(scanner);
                    break;
                case 2:
                    rec.view_rec();
                    break;
                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    rec.search_rec(searchId);
                    break;
                case 4:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}