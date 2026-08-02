public class Health extends Insurance {
    protected double maxCost;

    public Health(int customerCode, int duration, double maxCost) {
        super(customerCode, duration);
        this.maxCost = maxCost;
    }

    @Override
    public String toString() {
        return super.toString() + ", max capital to spend=" + maxCost;
    }

    @Override
    public double calculateCost() {
        int age = 0;
        boolean isMale = false; 
        
        for (int i = 0; i < Customer.customerArray.length; i++) {
            if (Customer.customerArray[i] != null) {
                if (Customer.customerArray[i].getPasscode() == customerCode) {
                    age = 2026 - Customer.customerArray[i].getBirthyear();
                    if (Customer.customerArray[i].getGender().equals("male")) {
                        isMale = true;
                    }
                }
            }
        }
        
        if (!isMale) {
            return super.calculateCost() + (age * 7);
        } else {
            return super.calculateCost() + (age * 7) + 50;
        }
    }

    public void setMaxCost(double maxCapital) {
        this.maxCost = maxCapital;
    }

    public double getMaxCost() {
        return maxCost;
    }
}
