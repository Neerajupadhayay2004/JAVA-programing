class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Check sign
        boolean negative = (dividend < 0) != (divisor < 0);

        // Convert to positive long
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        long quotient = 0;

        while (dividendAbs >= divisorAbs) {

            long temp = divisorAbs;
            long multiple = 1;

            // Double divisor as much as possible
            while (dividendAbs >= temp + temp) {
                temp = temp + temp;
                multiple = multiple + multiple;
            }

            // Subtract the biggest possible chunk
            dividendAbs = dividendAbs - temp;
            quotient = quotient + multiple;
        }

        // Apply sign
        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}