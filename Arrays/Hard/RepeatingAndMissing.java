package DSA_SHEET_JAVA.Arrays.Hard;

import java.util.ArrayList;

public class RepeatingAndMissing {
    public static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int repeat = -1, missing = -1;

        // Step 1: Use an array to count occurrences
        int[] count = new int[n + 1]; // Count array for numbers 1 to n

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1 && arr[i] <= n) { // Ensure it's within range
                count[arr[i]]++;
            }
        }

        // Step 2: Identify missing and repeating numbers
        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                repeat = i; // Repeating number
            } else if (count[i] == 0) {
                missing = i; // Missing number
            }
        }

        result.add(repeat);
        result.add(missing);
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 4, 5 }; // Example input
        System.out.println(findTwoElement(arr)); // Output: [3, 2]
    }
}
