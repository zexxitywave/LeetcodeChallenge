class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Integer [][][] memo = new Integer [rows][cols][cols];
        return dfs(0, 0, cols-1, grid, memo);
    }
    private int dfs(int row, int col1, int col2, int[][]grid, Integer [][][] memo){
        int rows = grid.length, cols = grid[0].length;

        if(col1 < 0 || col2 < 0 || col1 >= cols || col2 >= cols){
            return 0;
        }

        if(memo[row][col1][col2]!= null){
            return memo[row][col1][col2];
        }

        int cherries = (col1 == col2)? grid[row][col1]: grid[row][col1] + grid[row][col2];
        
        int max = 0;
        if(row < rows - 1){
            for(int d1 = -1; d1 <= 1; d1++){
                for(int d2 = -1; d2 <= 1; d2++){
                    int next = dfs(row + 1, col1 + d1, col2 + d2, grid, memo);
                    max = Math.max(max, next);
                }
            }
        }
        cherries += max;
        return memo[row][col1][col2] = cherries;
    }
}