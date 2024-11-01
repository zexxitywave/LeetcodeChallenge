class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = {
            {0, 1}, {1, 1}, {1, 0}, {1, -1},
            {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
        };

        int rows = board.length;
        int cols = board[0].length;

        // First pass: Count live neighbors and mark changes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;
                
                // Count live neighbors
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    // Only count cells that are currently live (1) or marked to die (-1)
                    if (x >= 0 && x < rows && y >= 0 && y < cols && Math.abs(board[x][y]) == 1) {
                        liveNeighbors++;
                    }
                }
                
                // Apply Game of Life rules using the new markers
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1;  // Mark as live cell that will die
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;  // Mark as dead cell that will become alive
                }
            }
        }
        
        // Second pass: Update the board to the next state
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;  // Finalize dead cell
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;  // Finalize alive cell
                }
            }
        }
    }
}
