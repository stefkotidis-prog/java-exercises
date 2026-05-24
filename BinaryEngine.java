public class BinaryEngine {
    
    public int calculateSum(int[] bits) {
        int sum = 0;
        for (int i = 0; i < bits.length; i++) {
            
            if (bits[i] == 1) {
                sum += Math.pow(2, (bits.length - 1) - i);
            }
        }
        return sum;
    }
}
