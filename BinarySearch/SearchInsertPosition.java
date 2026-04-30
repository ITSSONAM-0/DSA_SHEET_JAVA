package DSA_SHEET_JAVA.BinarySearch;

public class SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] arr, int target) {
            int low = 0, high = arr.length - 1; // Initialize search range

            while (low <= high) { // Run Binary Search
                int mid = (low + high) / 2; // Find the middle index

                if (arr[mid] == target) // Target found
                    return mid;

                if (arr[mid] < target) // Target is greater, move right
                    low = mid + 1;
                else // Target is smaller, move left
                    high = mid - 1;
            }

            return low; // The correct insertion position
        }
    }

}
