class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> Ele = new HashMap<>();
        int n = nums.length;

        for(int i =0; i< n; i++){
            Ele.put(nums[i], i);
        }
        for(int i=0; i< n; i++){
            int complement= target - nums[i];
            if(Ele.containsKey(complement) && Ele.get(complement) != i){
                return new int[]{i, Ele.get(complement)};
            }
        }return new int[]{};
    }
}