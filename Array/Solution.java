import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 5, 3, 8, 1, 2 };
        Arrays.sort(nums);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
