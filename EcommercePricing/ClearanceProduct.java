package EcommercePricing;

public class ClearanceProduct extends StandardProduct implements Discountable{
    @Override
    public int getFinalPrice() {
        return 50;
    }   

    @Override 
    public int applyCoupon(int discountPercentage){
        return 50 - (discountPercentage/2);
    }
}
