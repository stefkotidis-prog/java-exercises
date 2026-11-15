package EcommercePricing;


public class Main {
    public static void main(String[] args) {
        // Δημιουργία αντικειμένων
        ProductBundle bundle = new ProductBundle();
        StandardProduct std1 = new StandardProduct();
        StandardProduct std2 = new StandardProduct();
        ClearanceProduct clr1 = new ClearanceProduct();

        // Έλεγχος του bundle
        System.out.println("--- Product Bundle ---");
        System.out.println("Ποσότητα: " + bundle.getQuantity());
        System.out.println("Αρχική Τιμή: " + bundle.getFinalPrice() + "€");
        System.out.println("Τιμή με κουπόνι (20): " + bundle.applyCoupon(20) + "€");

        // Έλεγχος απλών και εκπτωτικών προϊόντων
        System.out.println("\n--- Products ---");
        System.out.println("Τιμή Standard Product: " + std1.getFinalPrice() + "€");
        System.out.println("Τιμή Clearance Product: " + clr1.getFinalPrice() + "€");
        System.out.println("Τιμή Clearance με κουπόνι (20): " + clr1.applyCoupon(20) + "€");

        // Έλεγχος του static counter
        System.out.println("\n--- Static Counter ---");
        // Δημιουργήσαμε 2 StandardProduct και 1 ClearanceProduct (που κληρονομεί από StandardProduct)
        // Άρα ο counter πρέπει να είναι 3
        System.out.println("Συνολικά Προϊόντα (Standard & Clearance) που δημιουργήθηκαν: " + StandardProduct.getTotalProducts());
    }
}
