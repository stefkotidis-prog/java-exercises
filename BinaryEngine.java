public class BinaryEngine {
    // Υπολογίζει το δεκαδικό άθροισμα ενός πίνακα από bits
    public int calculateSum(int[] bits) {
        int sum = 0;
        for (int i = 0; i < bits.length; i++) {
            // Δύναμη του 2 ανάλογα με τη θέση (από δεξιά προς τα αριστερά)
            if (bits[i] == 1) {
                sum += Math.pow(2, (bits.length - 1) - i);
            }
        }
        return sum;
    }
}