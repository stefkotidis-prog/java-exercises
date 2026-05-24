public class Product {
    // Instance variables
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(String name, double price) {
        this.name = name; // Using 'this' to handle shadowing
        this.price = price;
        this.quantity = 0; // Initially, no quantity is ordered
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    // Setters
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    // Μethod to increase quantity
    public void addQuantity(int q) {
        if (q >= 0) {
            this.quantity += q;
        }
    }
}