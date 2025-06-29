class Solution {
    private void backTracking(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0 || index >= candidates.length){
            return;
        }

        current.add(candidates[index]);
        backTracking(candidates, target - candidates[index], index, result, current);
        current.remove(current.size()-1);

        backTracking(candidates, target, index + 1, result, current);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(candidates, target, 0, result, new ArrayList<>());
        return result;
        
    }
}