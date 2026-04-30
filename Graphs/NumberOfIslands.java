package DSA_SHEET_JAVA.Graphs;

public class NumberOfIslands {
    int rows;
    int cols;

    void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;

        dfs(row - 1, col, grid, visited);
        dfs(row + 1, col, grid, visited);
        dfs(row, col - 1, grid, visited);
        dfs(row, col + 1, grid, visited);

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }

            }
        }
        return count;
    }
}
