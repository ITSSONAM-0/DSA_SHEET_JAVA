package DSA_SHEET_JAVA.BinarySearch;

public class Basics {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, 5, 6, 7, 8, 9, 16, 17 };
        int target = 9;
        int ans = search(nums, target);
        System.out.println(ans);
    }
}
