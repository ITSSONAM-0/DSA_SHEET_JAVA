package DSA_SHEET_JAVA.GreedyAlgorithms;

import java.util.Arrays;

public class AssignCookis {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {

                i++;
            }
            j++;
        }
        return i;
    }
}
