import java.text.DecimalFormat;

/**
 * Core data model for the ATM.
 * Handles user credentials and account balances securely.
 */
public class Atm {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    

    //Printing more appealing to user putting $ sign and comma every three digits and removing decimals if not needed
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Methods used for calculating and updating transactions
    public void calcCheckingWithdraw(double amount) {
        checkingBalance = checkingBalance - amount;
    }

    public void calcSavingWithdraw(double amount) {
        savingBalance = savingBalance - amount;
    }

    public void calcCheckingDeposit(double amount) {
        checkingBalance = checkingBalance + amount;
    }

    public void calcSavingDeposit(double amount) {
        savingBalance = savingBalance + amount;
    }
}