import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;

        // Δημιουργία δεδομένων
        Customer cust1 = new Customer("Mixalis", 1993, "male");
        new Life(cust1.getPasscode(), 10, 10000);
        new Health(cust1.getPasscode(), 11, 12000);

        Customer cust2 = new Customer("Haris", 1978, "male");
        new Health(cust2.getPasscode(), 6, 5000);
        new Life(cust2.getPasscode(), 3, 14562);

        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Print all insurances");
            System.out.println("2. Insert customer's code to see his insurances");
            System.out.println("3. Insert insurance code to see its type");
            System.out.println("* To exit enter any other number");
            System.out.print("Choose an option: ");
            option = input.nextInt();

            if (option == 1) {
                Insurance.printInsurances();

            } else if (option == 2) {
                System.out.print("Insert customer's code to see his insurances: ");
                int customerCode = input.nextInt();
                Insurance.findInsurance(customerCode);

            } else if (option == 3) {
                System.out.print("Insert insurance code to see its type: ");
                int insCode = input.nextInt();
                boolean found = false;

                // Ασφαλής αναζήτηση στον πίνακα για να μη σκάσει το πρόγραμμα
                for (int i = 0; i < Insurance.insuranceArray.length; i++) {
                    Insurance current = Insurance.insuranceArray[i];
                    
                    if (current != null && current.code == insCode) {
                        found = true;
                        if (current instanceof Life) {
                            double capital = ((Life) current).capital;
                            System.out.println("--> It's a Life insurance with capital: " + capital);
                        } else if (current instanceof Health) {
                            double cost = ((Health) current).maxCost;
                            System.out.println("--> It's a Health insurance with max cost to spend: " + cost);
                        }
                        break; // Το βρήκαμε, σταματάμε το ψάξιμο
                    }
                }
                if (!found) {
                    System.out.println("No insurance found with that code.");
                }
            }

        } while (option >= 1 && option <= 3);
        
        System.out.println("Exiting program...");
        input.close();
    }
}