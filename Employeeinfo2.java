// File: EmployeeInfo.java
import java.util.Scanner;

public class EmployeeInfo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept employee info using Scanner
        System.out.println("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.println("Enter Employee Department: ");
        String dept = sc.nextLine();

        // String operations
        System.out.println("\n--- Employee Information ---");
        System.out.println("Original Name: " + name);
        System.out.println("Uppercase Name: " + name.toUpperCase());
        System.out.println("First 3 letters of Name: " + (name.length() >= 3 ? name.substring(0, 3) : name));
        System.out.println("Welcome Message: " + name.concat(" has joined the " + dept + " department."));

        // Processing command-line arguments
        System.out.println("\n--- Batch Update from Command-line Arguments ---");
        if (args.length > 0) {
            System.out.println("Departments to update:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("Employee " + (i + 1) + " assigned to department: " + args[i]);
            }
        } else {
            System.out.println("No batch updates provided via command-line arguments.");
        }

        sc.close();
    }
}
