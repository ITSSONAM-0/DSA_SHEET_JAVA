package DSA_SHEET_JAVA.Arrays.Medium;

import java.util.Arrays;

public class RearrangeElementBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[posIndex] = nums[i];
                posIndex += 2;
            } else {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        int[] rearranged = rearrangeArray(nums);

        System.out.println(Arrays.toString(rearranged));
    }
}
