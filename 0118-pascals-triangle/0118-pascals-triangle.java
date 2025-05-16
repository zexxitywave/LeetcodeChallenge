class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> rows = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || i == j){
                    rows.add(1);
                }else{
                    int val = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    rows.add(val);
                }
            }
            ans.add(rows);
        }
        return ans;
    }
}