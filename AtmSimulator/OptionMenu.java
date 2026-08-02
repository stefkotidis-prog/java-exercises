import java.util.Scanner;
import java.util.InputMismatchException;


public class OptionMenu extends Atm {
    Scanner menuInput = new Scanner(System.in);


    public OptionMenu() {
        setCustomerNumber(12345);
        setPinNumber(1111);
    }


    public void getLogin() {

        System.out.println("Welcome to the ATM Project!");

        try {
            System.out.print("Enter your Customer Number: ");
            int enteredNumber = menuInput.nextInt();
            if (enteredNumber != getCustomerNumber()){
                System.out.println("\nERROR: Wrong Customer Number.\n");
                getLogin();
                return;
            }

            System.out.print("Account found. Enter your PIN: ");
            int enteredPin = menuInput.nextInt();
            if (enteredPin != getPinNumber()){
                System.out.println("\nERROR: Wrong PIN.\n");
                getLogin();
                return;
            }

            if (enteredNumber == getCustomerNumber() && enteredPin == getPinNumber()) {
                System.out.println("\nLogin Successful!");
                getAccountType();
            } 
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: Please enter numbers only.");
            menuInput.nextLine(); 
            getLogin();
        }
    }

    public void getAccountType() {
        System.out.println("\nSelect the Account you wish to access:");
        System.out.println(" 1 - Checking Account");
        System.out.println(" 2 - Savings Account");
        System.out.println(" 3 - Exit");
        System.out.print("Enter choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                
                getChecking();
                break;
            case 2:
                
                getSaving();
                break;
            case 3:
                
                System.out.println("You chose to exit. Thank you for using this ATM, bye!");
                System.exit(0);
                break;
            default:
                System.out.println("\nERROR: Invalid Choice, please try again.");
                getAccountType();
        }
    }
    

    public void getChecking() {
        System.out.println("\nYou are currently in Checking Account choose an option:");
        System.out.println(" 1 - View Balance");
        System.out.println(" 2 - Withdraw Funds");
        System.out.println(" 3 - Deposit Funds");
        System.out.println(" 4 - Back to Account Selection");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {

            case 1:
                System.out.println("Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                System.out.print("Withdraw amount: ");
                double withdrawAmount = menuInput.nextDouble();
                if (getCheckingBalance() - withdrawAmount >= 0 && withdrawAmount >= 0) {
                    calcCheckingWithdraw(withdrawAmount);
                    System.out.println("New Balance: " + moneyFormat.format(getCheckingBalance()));
                } else if (withdrawAmount < 0){
                    System.out.println("ERROR: Invalid amount");
                } else {
                    System.out.println("ERROR: Insufficient funds.");
                    System.out.println("Current checking's account balance is: " + moneyFormat.format(getCheckingBalance()));
                }
                getAccountType();
                break;
            case 3:
                System.out.print("Deposit amount: ");
                double depositAmount = menuInput.nextDouble();
                if (depositAmount > 0) {
                    calcCheckingDeposit(depositAmount);
                    System.out.println("New Balance: " + moneyFormat.format(getCheckingBalance()));
                } else {
                    System.out.println("ERROR: Amount cannot be negative.");
                }
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("\nERROR: Invalid Choice, please try again.");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("\nYou are currently in the Savings Account choose an option:");
        System.out.println(" 1 - View Balance");
        System.out.println(" 2 - Withdraw Funds");
        System.out.println(" 3 - Deposit Funds");
        System.out.println(" 4 - Back to Account Selection");
        System.out.print("Enter choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Current balance is: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = menuInput.nextDouble();
                if (getSavingBalance() - withdrawAmount >= 0 && withdrawAmount >= 0) {
                    calcSavingWithdraw(withdrawAmount);
                    System.out.println("Balance updated!");
                    System.out.println("New Balance: " + moneyFormat.format(getSavingBalance()));
                } else if ( withdrawAmount < 0) {
                    System.out.println("ERROR: Invalid Amount.");
                } else{
                    System.out.println("ERROR: Insufficient funds.");
                    System.out.println("Current balance is: " + moneyFormat.format(getSavingBalance()));
                }
                getAccountType();
                break;
            case 3:
                System.out.print("Deposit amount: ");
                double depositAmount = menuInput.nextDouble();
                if (depositAmount > 0) {
                    calcSavingDeposit(depositAmount);
                    System.out.println("Balance updated!");
                    System.out.println("New Balance: " + moneyFormat.format(getSavingBalance()));
                } else {
                    System.out.println("ERROR: Amount cannot be negative.");
                }
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("\nERROR: Invalid Choice, please try again.");
                getSaving();
        }
    }
}
