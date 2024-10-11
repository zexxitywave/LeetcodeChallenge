class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int c = m + n; 
        int[] merged = new int[c]; 
        
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        if (c % 2 != 0) {
            return merged[c / 2];
        } else {
            int mid1 = c / 2 - 1;
            int mid2 = c / 2;
            return (merged[mid1] + merged[mid2]) / 2.0;
        }
    }
}
