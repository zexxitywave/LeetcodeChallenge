class Solution {
    public int singleNumber(int[] nums) {
        
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i =0; i < nums.length; i++){
            if(nums.length == 1){
                return nums[i];
            }
            else if(count.getOrDefault(nums[i],0) <2){
                count.put(nums[i], count.getOrDefault(nums[i],0)+1);
            }
        }
        for (int key : count.keySet()){
            if(count.get(key) == 1){
                return key;
            }
        }
        return -1;
    }
}