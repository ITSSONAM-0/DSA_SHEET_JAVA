public class singlen {

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR each number
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println("Single number is: " + singleNumber(nums));
    }
}
// Given a non-empty array of integers nums, every element appears twice except
// for one. Find that single one. You must implement a solution with a linear
// runtime complexity and use only constant extra space.