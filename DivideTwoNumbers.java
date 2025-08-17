class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Work with long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        while (a >= b) {
            long temp = b, multiple = 1;
            // Double divisor until it exceeds dividend
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;        // Reduce dividend
            result += multiple; // Add multiples
        }

        // Apply sign
        return ((dividend > 0) ^ (divisor > 0)) ? -result : result;
    }
}
