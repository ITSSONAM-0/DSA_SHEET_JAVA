package DSA_SHEET_JAVA.GreedyAlgorithms;

import java.util.Arrays;

public class ShortestJobFirst {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int n = bt.length;
        int totaltime = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            totaltime += time;
            time += bt[i];
        }
        return (totaltime / n);
    }
}
