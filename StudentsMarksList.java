// Lab Session 9: Collections Framework (ArrayList & Iterator)
// Topic: Implementing CRUD operations using ArrayList and traversing with Iterator

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Studentmarkslist {
    public static void main(String[] args) {
        ArrayList<Integer> marksList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Marks Management =====");
            System.out.println("1. Add Marks");
            System.out.println("2. View All Marks");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter marks to add: ");
                    int mark = sc.nextInt();
                    marksList.add(mark);
                    System.out.println("Marks added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Student Marks List ---");
                    if (marksList.isEmpty()) {
                        System.out.println("No marks found.");
                    } else {
                        Iterator<Integer> itr = marksList.iterator();
                        while (itr.hasNext()) {
                            System.out.println("Marks: " + itr.next());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter index to update (starting from 0): ");
                    int indexToUpdate = sc.nextInt();
                    if (indexToUpdate >= 0 && indexToUpdate < marksList.size()) {
                        System.out.print("Enter new marks: ");
                        int newMarks = sc.nextInt();
                        marksList.set(indexToUpdate, newMarks);
                        System.out.println("Marks updated successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.print("Enter index to delete (starting from 0): ");
                    int indexToDelete = sc.nextInt();
                    if (indexToDelete >= 0 && indexToDelete < marksList.size()) {
                        marksList.remove(indexToDelete);
                        System.out.println("Marks deleted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
