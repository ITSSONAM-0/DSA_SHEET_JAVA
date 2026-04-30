package DSA_SHEET_JAVA.TwoPointers;

public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int left = 0;
        int right = 0;

        while (left < n1 && right < n2) {
            if (nums1[left] == nums2[right]) {
                return nums1[left];
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else if (nums1[left] > nums2[right]) {
                right++;
            }
        }
        return -1;
    }
}
