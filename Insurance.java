public class Insurance {
    protected int customerCode;
    protected int code;
    protected int duration;
    protected static Insurance[] insuranceArray = new Insurance[10];
    protected static int insuranceCounter = 0;

    public Insurance(int customerCode, int duration) {
        insuranceArray[insuranceCounter] = this;
        this.customerCode = customerCode;
        this.duration = duration;
        insuranceCounter++;
        this.code = insuranceCounter;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Insurance [code=" + code + ", customerCode=" + customerCode + ", duration=" + duration + "]";
    }

    public double calculateCost() {
        return 100;
    }

    public static void printInsurances() {
        for (int i = 0; i < insuranceArray.length; i++) {
            if (insuranceArray[i] != null) {
                // BUG FIXED: Ήταν σκέτο insuranceArray, τώρα είναι insuranceArray[i]
                System.out.println(insuranceArray[i]); 
            }
        }
    }

    public static void findInsurance(int code) {
        boolean flag = false;
        for (int i = 0; i < insuranceArray.length; i++) {
            if (insuranceArray[i] != null && insuranceArray[i].customerCode == code) {
                System.out.println(insuranceArray[i]);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("No active insurance found for this customer.");
        }
    }
}