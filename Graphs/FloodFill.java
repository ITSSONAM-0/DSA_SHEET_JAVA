package DSA_SHEET_JAVA.Graphs;

public class FloodFill {
    int rows;
    int cols;

    void dfs(int row, int col, int newcolor, int curcolor, boolean visited[][], int image[][]) {

        // out of bound
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        // not 1
        if (image[row][col] != curcolor) {
            return;
        }

        // if already visited the element man what is question
        if (visited[row][col]) {
            return;
        }

        // set the 1 as 2
        image[row][col] = newcolor;
        visited[row][col] = true;

        // make the ajacency list
        int adjlist[][] = { { row - 1, col }, { row, col + 1 }, { row + 1, col }, { row, col - 1 } };
        for (int n[] : adjlist) {
            dfs(n[0], n[1], newcolor, curcolor, visited, image);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        boolean visited[][] = new boolean[rows][cols]; // default false;
        dfs(sr, sc, color, image[sr][sc], visited, image);
        return image;
    }
}
