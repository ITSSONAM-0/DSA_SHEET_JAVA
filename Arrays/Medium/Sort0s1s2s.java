package DSA_SHEET_JAVA.Arrays.Medium;

public class Sort0s1s2s {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0 };
        sortColors(nums);

        // Print sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
