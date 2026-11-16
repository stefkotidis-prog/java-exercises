import java.util.Random;

public class DiceSimulator {
    public static void main(String[] args) {
        Random random = new Random();
        int totalRolls = 36000; 
        
        // Array of size 13. I'm ignoring indices 0 and 1 because it makes 
        // mapping the sums (2-12) directly to the index way easier.
        int[] sumFrequencies = new int[13]; 

        System.out.println("Rolling two dice " + totalRolls + " times...\n");

        // 1. Simulate the rolls
        for (int i = 0; i < totalRolls; i++) {
            // Roll the dice (1 to 6)
            int die1 = 1 + random.nextInt(6); 
            int die2 = 1 + random.nextInt(6); 
            
            int sum = die1 + die2; 
            
            // Increment the counter directly at the sum's index (no need for inner loops!)
            sumFrequencies[sum]++; 
        }

        // 2. Print results and the histogram
        System.out.println("Probability Distribution (Sum of 2 Dice)");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-5s | %-10s | %s\n", "Sum", "Frequency", "Diagram (* = 200 rolls)");
        System.out.println("-------------------------------------------------------");

        // Loop through the possible sums (2 to 12)
        for (int sum = 2; sum <= 12; sum++) {
            
            // Print the sum and its count, nicely aligned
            System.out.printf("%-5d | %-10d | ", sum, sumFrequencies[sum]);
            
            // Print 1 star per 200 rolls so the bell curve fits on the screen
            int stars = sumFrequencies[sum] / 200;
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println(); // Next line for the next sum
        }
        
        System.out.println("-------------------------------------------------------");
    }
}