
import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeduplicate(int[] arr) {
        if (arr.length == 0) return 0; // Edge case: empty array
        
        int i = 0; // Pointer for the unique element
        for (int j = 1; j < arr.length; j++) { // Fix: Use j < arr.length
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j]; // Store unique value at next position
            }
        }
        return i + 1; // Return length of unique elements
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 3};
        int newLength = removeduplicate(arr);

        // Print the unique elements
        System.out.println("Unique elements: " + Arrays.toString(Arrays.copyOf(arr, newLength)));
    }
}
