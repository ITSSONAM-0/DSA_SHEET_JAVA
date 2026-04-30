package DSA_SHEET_JAVA.GreedyAlgorithms;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int r = 0;
        int l = 0;

        while (r < n - 1) {
            int far = 0;
            for (int i = l; i <= r; i++) {
                far = Math.max(i + nums[i], far);
            }
            l = r + 1;
            r = far;
            jumps++;
        }
        return jumps;
    }
}
