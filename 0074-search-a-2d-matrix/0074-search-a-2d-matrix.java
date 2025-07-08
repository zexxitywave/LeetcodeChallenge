class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0 || matrix[0].length == 0) return false;

        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int midValue = matrix[mid/col][mid%col];

            if(target == midValue){
                return true;
            }else if(target > midValue){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}