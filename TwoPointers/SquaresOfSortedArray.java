package DSA_SHEET_JAVA.TwoPointers;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int left = 0;
        int right = n - 1;
        int j = n - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[j] = nums[left] * nums[left];
                j--;
                left++;
            } else {
                res[j] = nums[right] * nums[right];
                j--;
                right--;
            }
        }
        return res;
    }
}
