// File: Book.java
class Book{
    String title;
    String author;
    double price;

    // Constructor using 'this' keyword
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void display() {
        System.out.println("Book Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
    }

    public static void main(String[] args) {
        // Creating objects
        Book b1 = new Book("Java Programming", "James Gosling", 499.50);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 599.99);

        // Display details
        System.out.println("--- Book 1 Details ---");
        b1.display();

        System.out.println("\n--- Book 2 Details ---");
        b2.display();
    }
}
