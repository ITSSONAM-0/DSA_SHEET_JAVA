public class wordsearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {

        // If all characters matched
        if (index == word.length())
            return true;

        // Out of bounds OR mismatch
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore neighbors
        boolean found = dfs(board, word, i + 1, j, index + 1) || // down
                dfs(board, word, i - 1, j, index + 1) || // up
                dfs(board, word, i, j + 1, index + 1) || // right
                dfs(board, word, i, j - 1, index + 1); // left

        // Restore original value (backtrack)
        board[i][j] = temp;

        return found;
    }

    // Test the solution
    public static void main(String[] args) {
        wordsearch ws = new wordsearch();

        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        System.out.println(ws.exist(board, "ABCCED")); // true
        System.out.println(ws.exist(board, "SEE")); // true
        System.out.println(ws.exist(board, "ABCB")); // false
    }
}
