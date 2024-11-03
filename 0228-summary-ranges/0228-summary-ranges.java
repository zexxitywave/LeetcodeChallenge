class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> range = new ArrayList<>();
        if(nums.length == 0) return range;

        int start = 0;

        for(int i =1; i <= nums.length; i++){
            if(i == nums.length || nums[i]!= nums[i-1]+1){
                if(start == i-1){
                    range.add(String.valueOf(nums[start]));
                }else{
                    range.add(nums[start]+"->"+nums[i-1]);
                }
                start = i;
            }
            
        }
        return range;
    }
}