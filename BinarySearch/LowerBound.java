package DSA_SHEET_JAVA.BinarySearch;

public class LowerBound {
    static int findFloor(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1; // Default value if no floor exists

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= k) {
                ans = mid; // Possible floor index
                low = mid + 1; // Move right to find a greater floor
            } else {
                high = mid - 1; // Move left
            }
        }
        return ans; // Index of the floor element
    }
}
