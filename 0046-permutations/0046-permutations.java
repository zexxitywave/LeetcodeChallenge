class Solution {
    private void sol(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true) continue;

            visited[i] = true;
            current.add(nums[i]);
            sol(nums, visited, current, result);
            current.remove(current.size()-1);
            visited[i] = false;

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        sol(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }
}