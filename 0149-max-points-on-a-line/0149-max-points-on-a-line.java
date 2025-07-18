class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> mp = new HashMap<>();
            int max = 0;
            int same = 1;
            for(int j = i+1; j < points.length; j++){
                double dy = (double) (points[j][1] - points[i][1]);
                double dx = (double) (points[j][0] - points[i][0]);
                if(dy == 0 && dx == 0){
                    same++;
                }else{
                    double m;
                    if(dx == 0){
                        m = Double.POSITIVE_INFINITY;
                    }else if(dy == 0){
                        m = 0.0;
                    }else{
                        m = dy/dx;
                    }
                    mp.put(m, mp.getOrDefault(m,0) + 1);
                    max = Math.max(max, mp.get(m));
                }
            }
            ans = Math.max(ans, max + same);
        }
        return ans;
    }
}