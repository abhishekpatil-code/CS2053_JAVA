// Lab Session 7: Multithreading and Synchronization
// Topic: Simulate multiple users printing through a shared Printer object

// Class representing a shared Printer
class Printer {
    // synchronized method ensures only one thread uses the printer at a time
    public synchronized void printDocument(String user, String document) {
        System.out.println(user + " started printing: " + document);
        try {
            // Simulate time taken to print
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Printing interrupted for " + user);
        }
        System.out.println(user + " finished printing: " + document);
    }
}

// Runnable class representing a User
class User implements Runnable {
    private String userName;
    private String documentName;
    private Printer printer;

    // Constructor
    public User(String userName, String documentName, Printer printer) {
        this.userName = userName;
        this.documentName = documentName;
        this.printer = printer;
    }

    // Thread’s run method
    @Override
    public void run() {
        printer.printDocument(userName, documentName);
    }
}

// Main class
public class PrinterSimulation {
    public static void main(String[] args) {
        Printer sharedPrinter = new Printer();

        // Create multiple users (threads)
        Thread user1 = new Thread(new User("Alice", "Report.pdf", sharedPrinter));
        Thread user2 = new Thread(new User("Bob", "Invoice.docx", sharedPrinter));
        Thread user3 = new Thread(new User("Charlie", "Assignment.java", sharedPrinter));

        // Start all threads
        user1.start();
        user2.start();
        user3.start();
    }
}
