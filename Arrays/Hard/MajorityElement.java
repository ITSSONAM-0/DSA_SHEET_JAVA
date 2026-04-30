package DSA_SHEET_JAVA.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int s = n / 3;

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > s && !ls.contains(nums[i])) {
                ls.add(nums[i]);
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement(); // ✅ Fixed class name

        // Example test case
        int[] nums = { 3, 2, 3 };
        List<Integer> result = sol.majorityElement(nums);

        // Print the output
        System.out.println("Majority elements: " + result);
    }
}
