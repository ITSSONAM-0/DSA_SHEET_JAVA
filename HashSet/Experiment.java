package DSA_SHEET_JAVA.HashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class Experiment {

    static int[] removedupicate(int[] arr) {

        HashSet<Integer> hs = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }

        ArrayList<Integer> ls = new ArrayList<>(hs);

        int nums[] = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            nums[i] = ls.get(i);
        }

        return nums;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 5, 4, 5, 6, 9, 2, 1, 7, 8, 3, 0 };
        int ans[] = removedupicate(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
