package DSA_SHEET_JAVA.TwoPointers;

public class MinimumLengthofStringAfterDeletingSimilarEnds {
    public int minimumLength(String str) {
        int n = str.length();
        int p = 0;
        int s = n - 1;

        while (p < s && str.charAt(p) == str.charAt(s)) {
            char ch = str.charAt(p);

            while (p <= s && str.charAt(p) == ch) {
                p++;
            }

            while (p <= s && str.charAt(s) == ch) {
                s--;
            }
        }
        return (s - p) + 1;
    }
}
