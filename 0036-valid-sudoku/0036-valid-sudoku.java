class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String>seen = new HashSet<>();

        for(int r =0; r< 9; r++){
            for(int c = 0; c <9; c++){
                char num = board[r][c];
                if(num != '.'){
                    if((!seen.add(num + "at row"+ r) || 
                   (!seen.add(num + "at col" + c)) ||
                   (!seen.add(num + "at box"+ r/3 +","+ c/3)))){
                    return false;
                   }
                }
            }
        }
        return true;
    }
}