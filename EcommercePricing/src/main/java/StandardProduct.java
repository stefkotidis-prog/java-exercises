package EcommercePricing;

public class StandardProduct implements PricedItem{
    private static int totalProducts = 0;
    
    public StandardProduct() {
        totalProducts++;
    }
    
    public static int getTotalProducts() {
        return totalProducts;
    }

    @Override 
    public int getFinalPrice(){
        return 100;
    }
}
