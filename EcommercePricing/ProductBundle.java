package EcommercePricing;

public class ProductBundle implements PricedItem, Discountable{
    private int quantity = 3;

    public int getQuantity(){
        return quantity;
    }

    @Override
    public int getFinalPrice(){
        return 40 * quantity;
    }

    public int applyCoupon(int discountPercentage){
        return getFinalPrice() - discountPercentage;
    }
}
