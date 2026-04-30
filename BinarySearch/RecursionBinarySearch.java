package DSA_SHEET_JAVA.BinarySearch;

public class RecursionBinarySearch {
    public static int search(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;

        else if (target > nums[mid])
            return search(nums, mid + 1, high, target);

        return search(nums, mid - 1, low, target);
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, 5, 6, 7, 8, 9, 16, 17 };
        int target = 9;
        int low = 0;
        int high = nums.length - 1;
        int ans = search(nums, low, high, target);
        System.out.println(ans);
    }
}
