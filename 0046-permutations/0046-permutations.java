class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(nums, resultList, new ArrayList<>());
        return resultList;
    }
    private void backtrack(int[]nums, List<List<Integer>> resultList, ArrayList<Integer>tempList){
        if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int number: nums){
            if(tempList.contains(number))
                continue;
            tempList.add(number);
            backtrack(nums, resultList, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}