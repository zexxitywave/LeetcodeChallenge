class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || m == 0 || k == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<> ((a,b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        for(int i = 0; i < Math.min(n, k); i++){
            pq.offer(new int[]{i, 0});
        }

        while(k --> 0 && !pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];

            res.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));

            if(j + 1 < m){
                pq.offer(new int[]{i, j + 1});
            }
        }
        return res;
    }
}