public class Customer {
    private String name;
    private int birthYear;
    private String gender;
    private int passcode;

    public static Customer[] customerArray = new Customer[10];
    private static int customerCounter = 0;

    public Customer(String name, int birthYear, String gender) {
        customerArray[customerCounter] = this;
        customerCounter++;
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.passcode = customerCounter;
    }

    @Override
    public String toString() {
        return "Customer [name: " + name + ", birth year: " + birthYear + ", gender: " + gender + ", passcode: " + passcode + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }

    public String getName() {
        return name;
    }

    public int getBirthyear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public int getPasscode() {
        return passcode;
    }
}
