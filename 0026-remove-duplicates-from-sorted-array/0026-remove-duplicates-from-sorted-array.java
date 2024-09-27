class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> uniqueNum = new HashMap<>();
        int index = 0;

        for(int i =0; i< nums.length; i++){
            if(!uniqueNum.containsKey(nums[i])){
                uniqueNum.put(nums[i],1);
                nums[index]= nums[i];
                index++;
            }else{
                uniqueNum.put(nums[i],uniqueNum.get(nums[i]+1));
            }
        }return index;
    }
}