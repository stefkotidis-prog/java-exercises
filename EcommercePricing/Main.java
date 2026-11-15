package EcommercePricing;

public class Main {
    public static void main(String[] args) {
        ProductBundle bundle = new ProductBundle();
        StandardProduct std1 = new StandardProduct();
        StandardProduct std2 = new StandardProduct();
        ClearanceProduct clr1 = new ClearanceProduct();

        System.out.println("--- Product Bundle ---");
        System.out.println("Quantity: " + bundle.getQuantity());
        System.out.println("Original Price: " + bundle.getFinalPrice() + "€");
        System.out.println("Price with coupon (20): " + bundle.applyCoupon(20) + "€");

        System.out.println("\n--- Products ---");
        System.out.println("Standard Product Price: " + std1.getFinalPrice() + "€");
        System.out.println("Clearance Product Price: " + clr1.getFinalPrice() + "€");
        System.out.println("Clearance Product with coupon (20): " + clr1.applyCoupon(20) + "€");

        System.out.println("\n--- Static Counter ---");
        System.out.println("Total Products Created: " + StandardProduct.getTotalProducts());
    }
}