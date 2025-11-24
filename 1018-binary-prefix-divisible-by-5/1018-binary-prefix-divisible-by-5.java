class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new LinkedList<>();
        int curr = 0;

        for(int n : nums){
            curr = ((curr << 1) + n) % 5;
            ans.add(curr == 0); 
        }

        return ans;
    }
}