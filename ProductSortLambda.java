import java.util.*;

// Product class representing each product with name and price
class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Display format
    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}

public class ProductSortLambda {
    public static void main(String[] args) {
        // Creating list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 65000));
        products.add(new Product("Mouse", 700));
        products.add(new Product("Keyboard", 1500));
        products.add(new Product("Monitor", 12000));
        products.add(new Product("Headphones", 2500));

        System.out.println("Original Product List:");
        products.forEach(System.out::println);

        // 🔹 Sort by Price using Lambda Expression
        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        System.out.println("\nSorted by Price (Ascending):");
        products.forEach(System.out::println);

        // 🔹 Sort by Name using Lambda Expression
        Collections.sort(products, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        System.out.println("\nSorted by Name (Alphabetical):");
        products.forEach(System.out::println);
    }
}
