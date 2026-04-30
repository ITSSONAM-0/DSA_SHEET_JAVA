package DSA_SHEET_JAVA.BasicMath;

import java.util.*;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dup = n; // Duplicate of the original number
        int cntDigits = String.valueOf(n).length(); // Count the number of digits
        int sum = 0;

        while (n > 0) {
            int ld = n % 10; // Extract last digit
            sum += Math.pow(ld, cntDigits); // Add the digit raised to the power of cntDigits
            n /= 10; // Remove the last digit
        }

        if (dup == sum) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        sc.close();
    }
}
