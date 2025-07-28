class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // DFS from borders
        for (int i = 0; i < cols; i++) {
            dfs(0, i, board);           // top row
            dfs(rows - 1, i, board);    // bottom row
        }
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, board);           // left column
            dfs(i, cols - 1, board);    // right column
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;

        board[r][c] = '1'; // Temporarily mark as visited

        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}
