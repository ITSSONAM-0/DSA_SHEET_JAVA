package DSA_SHEET_JAVA.Graphs;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> res = new ArrayList<>();
        int v = adj.size();
        boolean visited[] = new boolean[v];
        for (int i = 0; i < visited.length; i++) {
            if (!(visited[i])) {
                dfs(i, visited, adj, res);
            }
        }
        return res;

    }

    public void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        visited[node] = true;
        res.add(node);
        for (int n : adj.get(node)) {
            if (!(visited[n])) {
                dfs(n, visited, adj, res);
            }
        }
    }
}
