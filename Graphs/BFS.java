package DSA_SHEET_JAVA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();
        boolean visited[] = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.remove();
            res.add(node);

            for (int n : adj.get(node)) {
                if (!(visited[n])) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        return res;
    }
}
