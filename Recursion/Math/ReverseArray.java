package DSA_SHEET_JAVA.Recursion.Math;

import java.util.Scanner;

public class ReverseArray {

    static void fun(int i, int arr[], int n) {
        if (i >= n / 2) {
            return;
        }
        // Swap elements at i and n-i-1
        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;

        // Recursive call for the next pair
        fun(i + 1, arr, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the Array Elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Reverse the array using recursion
        fun(0, arr, n);

        // Display the reversed array
        System.out.println("Reversed Array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
