package DSA_SHEET_JAVA.Arrays.Hard;

import java.util.*;

//brute force approach

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> temp = new ArrayList(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // optimal solution
    public List<List<Integer>> fourSumo(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Sorting helps avoid duplicate triplets

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // Skip duplicate values for i
                continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) // Skip duplicate values for j
                    continue;

                int k = j + 1, l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // Prevent overflow

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for k and l
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

}
