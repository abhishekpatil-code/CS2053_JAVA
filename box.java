// Lab Session 8: Wrapper Classes and Generics
// Topic: Generic class, Wrapper classes, Autoboxing, and Collections

import java.util.ArrayList;

// Generic class Box<T> that can store any type of object
class Box<T> {
    private ArrayList<T> items = new ArrayList<>();

    // Method to add an item
    public void addItem(T item) {
        items.add(item);
    }

    // Method to display all items
    public void displayItems() {
        System.out.println("Items in the Box:");
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Main class
public class BoxDemo {
    public static void main(String[] args) {
        // Box for Integers (autoboxing: int → Integer)
        Box<Integer> intBox = new Box<>();
        intBox.addItem(10);     // Autoboxing
        intBox.addItem(20);
        intBox.addItem(30);

        // Box for Strings
        Box<String> strBox = new Box<>();
        strBox.addItem("Laptop");
        strBox.addItem("Keyboard");
        strBox.addItem("Mouse");

        // Box for Doubles (autoboxing: double → Double)
        Box<Double> doubleBox = new Box<>();
        doubleBox.addItem(12.5);
        doubleBox.addItem(45.7);
        doubleBox.addItem(78.9);

        // Display all boxes
        System.out.println("=== Integer Box ===");
        intBox.displayItems();

        System.out.println("\n=== String Box ===");
        strBox.displayItems();

        System.out.println("\n=== Double Box ===");
        doubleBox.displayItems();
    }
}
