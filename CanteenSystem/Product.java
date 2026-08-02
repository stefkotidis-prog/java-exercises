public class Product {
   
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price) {
        this.name = name; 
        this.price = price;
        this.quantity = 0; 
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public void addQuantity(int q) {
        if (q >= 0) {
            this.quantity += q;
        }
    }
}
