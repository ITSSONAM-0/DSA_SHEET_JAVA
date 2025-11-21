public class computepower {

    public static double myPow(double x, int n) {
        // Base case
        if (n == 0)
            return 1.0;

        // Handle negative powers
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double half = myPow(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10)); // 1024.0
        System.out.println(myPow(2.1, 3)); // 9.261
        System.out.println(myPow(2.0, -2)); // 0.25
    }
}

// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).