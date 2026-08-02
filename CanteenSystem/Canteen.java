import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create 5 Product objects
        Product toast = new Product("Toast", 2.50);
        Product coffee = new Product("Coffee", 1.80);
        Product juice = new Product("Juice", 2.00);
        Product water = new Product("Water", 0.50);
        Product bagel = new Product("Bagel", 1.20);

        // Variables to handle the cancellation of the last entry
        Product lastProductAdded = null;
        int lastQuantityAdded = 0;

        int choice = -1;

        System.out.println("=== Welcome to the Canteen Ordering System ===");

        // Order menu loop
        while (choice != 0) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Toast (2.50€)");
            System.out.println("2. Coffee (1.80€)");
            System.out.println("3. Juice (2.00€)");
            System.out.println("4. Water (0.50€)");
            System.out.println("5. Bagel (1.20€)");
            System.out.println("6. Cancel last entry");
            System.out.println("0. Complete order");
            System.out.print("Select an option: ");

            // Protection against string/character input (Input mismatch)
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid selection. Please enter a number.");
                scanner.next(); // clear the invalid input
                continue;
            }
            
            choice = scanner.nextInt();

            // Check for order completion
            if (choice == 0) {
                break;
            }

            // Handle cancellation option
            if (choice == 6) {
                if (lastProductAdded != null) {
                    // Calculate new quantity and save using setQuantity and getQuantity
                    int currentQty = lastProductAdded.getQuantity();
                    lastProductAdded.setQuantity(currentQty - lastQuantityAdded);
                    System.out.println("-> Canceled addition: " + lastQuantityAdded + "x " + lastProductAdded.getName());
                    
                    // Reset variables to prevent multiple consecutive cancellations of the same action
                    lastProductAdded = null; 
                    lastQuantityAdded = 0;
                } else {
                    System.out.println("-> No previous entry to cancel.");
                }
                continue; // Return to the beginning of the menu
            }

            // Find the selected product
            Product selectedProduct = null;
            switch (choice) {
                case 1: selectedProduct = toast; break;
                case 2: selectedProduct = coffee; break;
                case 3: selectedProduct = juice; break;
                case 4: selectedProduct = water; break;
                case 5: selectedProduct = bagel; break;
                default: 
                    System.out.println("-> Invalid menu selection.");
                    continue; // Ignore the rest and go to the next iteration
            }

            // Prompt for quantity (if the selection was valid 1-5)
            System.out.print("Enter quantity for " + selectedProduct.getName() + ": ");
            if (!scanner.hasNextInt()) {
                System.out.println("-> Invalid quantity.");
                scanner.next(); // clear input
                continue;
            }
            
            int quantity = scanner.nextInt();

            // Quantity validity check
            if (quantity <= 0) {
                System.out.println("-> Invalid quantity. Must be greater than zero.");
            } else {
                // Update product quantity
                selectedProduct.addQuantity(quantity);
                System.out.println("-> Added " + quantity + " " + selectedProduct.getName() + " to the order.");
                
                // Store info in case a cancellation is requested next
                lastProductAdded = selectedProduct;
                lastQuantityAdded = quantity;
            }
        } // End of menu loop

        // Calculate total items ordered
        int totalItems = toast.getQuantity() + coffee.getQuantity() + juice.getQuantity() + water.getQuantity() + bagel.getQuantity();
        
        // If no items were ordered, terminate the program
        if (totalItems == 0) {
            System.out.println("No order was placed. Exiting...");
            scanner.close();
            return;
        }
        
        // Calculate base total cost
        double totalCostBase = (toast.getQuantity() * toast.getPrice()) + 
                               (coffee.getQuantity() * coffee.getPrice()) + 
                               (juice.getQuantity() * juice.getPrice()) + 
                               (water.getQuantity() * water.getPrice()) + 
                               (bagel.getQuantity() * bagel.getPrice());

        // Check for student discount
        boolean isStudent = false;
        String answer = "";
        scanner.nextLine(); // Clear the buffer
        
        while (true) {
            System.out.print("\nAre you a student? (Yes/No): ");
            answer = scanner.nextLine().trim().toUpperCase();
            if (answer.equals("YES")) {
                isStudent = true;
                break;
            } else if (answer.equals("NO")) {
                break;
            } else {
                System.out.println("Invalid answer. Please type 'Yes' or 'No'.");
            }
        }

        // Calculate discount percentage
        int discountPercentage = 0;
        
        if (totalCostBase > 15.0) {
            discountPercentage += 10;
        }
        if (totalItems >= 8) {
            discountPercentage += 5;
        }
        if (isStudent) {
            discountPercentage += 5;
        }

        // The total discount cannot exceed 15%
        if (discountPercentage > 15) {
            discountPercentage = 15;
        }

        double discountAmount = totalCostBase * (discountPercentage / 100.0);
        double finalCost = totalCostBase - discountAmount;

        // Payment Process
        double payment = 0.0;
        System.out.printf("\nThe final payment amount is: %.2f€\n", finalCost);
        
        while (payment < finalCost) {
            System.out.print("Enter payment amount: ");

            // Check if the user entered a valid number
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount.");
                scanner.next();
                continue;
            }

            double inputPayment = scanner.nextDouble();
            if (inputPayment < 0) {
                System.out.println("Amount cannot be negative.");
                continue;
            }
            payment += inputPayment;
            
            if (payment < finalCost) {
                System.out.printf("Insufficient amount. Remaining: %.2f€\n", (finalCost - payment));
            }
        }
        
        // Calculate change
        double change = payment - finalCost;

        // Print Receipt
        System.out.println("\n==================================");
        System.out.println("             RECEIPT              ");
        System.out.println("==================================");
        
        // Print receipt using printf for column alignment and 2 decimal places
        if (toast.getQuantity() > 0) System.out.printf("%-15s x%d = %.2f€\n", toast.getName(), toast.getQuantity(), toast.getQuantity() * toast.getPrice());
        if (coffee.getQuantity() > 0) System.out.printf("%-15s x%d = %.2f€\n", coffee.getName(), coffee.getQuantity(), coffee.getQuantity() * coffee.getPrice());
        if (juice.getQuantity() > 0) System.out.printf("%-15s x%d = %.2f€\n", juice.getName(), juice.getQuantity(), juice.getQuantity() * juice.getPrice());
        if (water.getQuantity() > 0) System.out.printf("%-15s x%d = %.2f€\n", water.getName(), water.getQuantity(), water.getQuantity() * water.getPrice());
        if (bagel.getQuantity() > 0) System.out.printf("%-15s x%d = %.2f€\n", bagel.getName(), bagel.getQuantity(), bagel.getQuantity() * bagel.getPrice());
        
        System.out.println("----------------------------------");
        System.out.println("Total items      : " + totalItems);
        System.out.printf("Subtotal         : %.2f€\n", totalCostBase);
        System.out.printf("Discount (%d%%)   : -%.2f€\n", discountPercentage, discountAmount);
        System.out.printf("Final Total      : %.2f€\n", finalCost);
        System.out.println("----------------------------------");
        System.out.printf("Payment          : %.2f€\n", payment);
        System.out.printf("Change           : %.2f€\n", change);
        System.out.println("==================================");
        System.out.println("           Thank you!             ");

        // Close the scanner (good practice)
        scanner.close();
    }
}