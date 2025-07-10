class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findFirstOccurence(nums, target);
        int right = findLastOccurence(nums, target);
        return new int[]{left, right};
    }

    private int findFirstOccurence(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                first = mid;
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return first;
    }

    private int findLastOccurence(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int last = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
                if(nums[mid] == target){
                    last = mid;
                    left = mid + 1;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
        }
        return last;
    }
}