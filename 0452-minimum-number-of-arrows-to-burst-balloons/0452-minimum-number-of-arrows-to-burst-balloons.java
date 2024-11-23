class Solution {
    public int findMinArrowShots(int[][] points) {

        if(points.length == 0 || points == null){
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = points.length;
        int prev[] = points[0];

        for(int i = 1; i< points.length; i++){
            int curr[] = points[i];
            if(curr[0] <= prev[1]){
                arrows--;
                prev[1] = Math.min(prev[1],curr[1]);
            }else{
                prev = curr;
            }
        }
        return arrows;
    }
}