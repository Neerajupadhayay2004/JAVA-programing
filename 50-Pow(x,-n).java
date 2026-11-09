
class Solution {
    public double myPow(double x, int n) {

        long power = Math.abs((long) n);

        double result = 1.0;

        while (power > 0) {

            if (power % 2 == 1) {
                result *= x;
            }

            x *= x;
            power /= 2;
        }

        // Take reciprocal only after calculation
        if (n < 0) {
            result = 1.0 / result;
        }

        return result;
    }
}
