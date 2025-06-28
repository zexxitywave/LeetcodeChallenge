class Solution {
    private void sol(int start, int n, int k, List<List<Integer>> result, List<Integer> combination){
        if(combination.size() == k){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i = start; i <= n; i++){
            combination.add(i);
            sol(i+1, n, k, result, combination);
            combination.remove(combination.size()-1);
        }
        
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        sol(1, n, k, result, new ArrayList<>());
        return result;
    }
}