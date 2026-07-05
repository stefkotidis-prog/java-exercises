import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class SlotMachine {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("Welcome to Java Slot Machine");
        System.out.println("---Symbols: ⭐️ 🍉 🍋 🔔 🍒 ---");
        System.out.println("----------------------------");
        System.out.println("Enter your starting balance: ");
        
        double balance;
        double payout;
        double bet;
        String[] row; 
        String playAgain;

        while (true) {
            try {
                balance = input.nextDouble();
                input.nextLine();
            } catch (InputMismatchException error) {
                System.out.println("ERROR: Enter only numbers!");
                input.next();
                continue;
            }
            if (balance <= 0) {
                System.out.println("ERROR: Enter an amount greater than 0!");
            } else {
                break;
            }
        }
        
        System.out.println("Your starting balance is: $" + balance);
        
        while (balance > 0) {
            System.out.println("Your current balance is: $" + balance);
            System.out.println("Place your bet amount: ");
            
            while (true) {
                try {
                    bet = input.nextDouble();
                    input.nextLine();
                } catch (InputMismatchException error) {
                    System.out.println("ERROR: Enter only numbers!");
                    input.next();
                    continue;
                }
                if (bet <= 0) {
                    System.out.println("ERROR: Enter an amount greater than 0!");
                } else if (bet > balance) {
                    System.out.println("ERROR: Insufficient funds");
                } else {
                    break;
                }
            }
            
            balance -= bet;
            System.out.println("Current balance: $" + balance);

            System.out.println("Spinning...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);
            
            if (payout > 0) {
                System.out.println("You won: $" + payout);
                balance += payout;
            } else {
                System.out.println("Sorry, you lost this round.");
            }
            
            System.out.println("Do you want to play again? (Y/N)");
            playAgain = input.next();
            if (playAgain.equalsIgnoreCase("n")) {
                break;
            }
        }
        
        System.out.println("Thanks for visiting the Java Slot Machine.");
        System.out.println("Your final balance is: $" + balance);

        input.close();
    }

    static String[] spinRow() {
        String[] symbols = {"⭐️", "🍉", "🍋", "🔔", "🍒"};
        String[] row = new String[3];
        Random random = new Random();
        
        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }
        return row;
    }

    static void printRow(String[] row) {
        System.out.println(String.join(" | ", row));
    }

    static double getPayout(String[] row, double bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch(row[0]) {       
                case "⭐️" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 5;
                case "🔔" -> bet * 10;
                case "🍒" -> bet * 20;
                default -> 0;
            };
        } else if (row[0].equals(row[1])) {
            return switch(row[0]) {       
                case "⭐️" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 6;
                case "🍒" -> bet * 7;
                default -> 0;
            };
        } else if (row[1].equals(row[2])) {
            return switch(row[1]) {       
                case "⭐️" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 6;
                case "🍒" -> bet * 7;
                default -> 0;
            };
        } else if (row[0].equals(row[2])) {
            return switch(row[0]) {
                case "⭐️" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 6;
                case "🍒" -> bet * 7;
                default -> 0;
            };
        }
        
        return 0; 
    }
}