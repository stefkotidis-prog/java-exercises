public class Life extends Insurance {
    protected double capital;

    public Life(int customerCode, int duration, double capital) {
        super(customerCode, duration);
        this.capital = capital;
    }

    @Override
    public String toString() {
        return super.toString() + ", capital=" + capital;
    }

    @Override
    public double calculateCost() {
        int age = 0;
        for (int i = 0; i < Customer.customerArray.length; i++) {
            if (Customer.customerArray[i] != null) {
                if (Customer.customerArray[i].getPasscode() == customerCode) {
                    age = 2026 - Customer.customerArray[i].getBirthyear();
                }
            }
        }
        return super.calculateCost() + (5 * age);
    }
}