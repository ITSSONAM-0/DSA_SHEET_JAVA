public class productofarray {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: fill answer[] with left products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: multiply with right products using a running variable
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        productofarray pa = new productofarray();

        int[] nums = { 1, 2, 3, 4 };
        int[] result = pa.productExceptSelf(nums);

        for (int x : result) {
            System.out.print(x + " ");
        }
        // Output: 24 12 8 6
    }
}
